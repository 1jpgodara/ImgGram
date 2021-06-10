package com.jp.imggram.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import java.io.IOException

class TopPhotosRemoteSource(
    private val imgurApi: ImgurApi
) : PagingSource<Int, String>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        return try {
            val response = imgurApi.getGalleryImages(
                pageNumber = params.key ?: 1,
                sectionType = "top"
            )
            val results = (response.body() as PhotosResponse).data.filter {
                !it.images.isNullOrEmpty() && !it.images[0].link.isNullOrBlank()
            }.map {
                it.images?.get(0)?.link ?: ""
            }


            LoadResult.Page(
                data = results,
                prevKey = params.key,
                nextKey = params.key?.plus(1) ?: 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, String>): Int? {
        return 1
    }
}
