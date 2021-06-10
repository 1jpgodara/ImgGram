package com.jp.imggram.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ImgurRepository {

    fun getTopImages(): Flow<PagingData<String>> {
        return Pager(
            config = PagingConfig(
                pageSize = 2,
                enablePlaceholders = true,
                prefetchDistance = 5
            ),
            pagingSourceFactory = { TopPhotosRemoteSource(getClient()) }
        ).flow
    }


    fun getHotImages(): Flow<PagingData<String>> {
        return Pager(
            config = PagingConfig(
                pageSize = 2,
                enablePlaceholders = true,
                prefetchDistance = 5
            ),
            pagingSourceFactory = { HotPhotosRemoteSource(getClient()) }
        ).flow
    }

    private fun getClient(): ImgurApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.imgur.com/3")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create(ImgurApi::class.java)
    }
}
