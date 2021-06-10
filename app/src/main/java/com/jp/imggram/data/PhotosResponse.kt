package com.jp.imggram.data

import androidx.recyclerview.widget.DiffUtil
import com.squareup.moshi.Json

data class PhotosResponse(
    @Json(name = "data") val data: List<Data>
)

data class Data(
    @Json(name = "images") val images: List<Image>?
)

data class Image(
    @Json(name = "link") val link: String?
)


data class FeedList(
    val imageLink: List<String>
) {
    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<String> =
            object : DiffUtil.ItemCallback<String>() {
                override fun areItemsTheSame(oldSection: String, newSection: String) =
                    oldSection == newSection

                override fun areContentsTheSame(oldSection: String, newSection: String) =
                    oldSection == newSection
            }
    }
}
