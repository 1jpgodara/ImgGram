package com.jp.imggram.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ImgurApi {

    companion object {
        private const val HEADER_AUTH = "Authorization"
    }

    @GET("/gallery/{section}}/time/day/{page}?showViral=true")
    suspend fun getGalleryImages(
        @Header(HEADER_AUTH) auth: String = "some_token",
        @Path("page") pageNumber: Int = 1,
        @Path("section") sectionType: String = "top"
    ): Response<PhotosResponse>
}
