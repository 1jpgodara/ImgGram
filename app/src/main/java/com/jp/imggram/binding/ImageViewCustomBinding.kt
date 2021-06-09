package com.jp.imggram.binding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.request.RequestOptions


object ImageViewCustomBinding {

    @BindingAdapter("src")
    fun bindSrc(view: ImageView, srcId: Int) {
        if (0 < srcId) {
            view.setImageResource(srcId)
        } else {
            view.setImageResource(0)
        }
    }

    @BindingAdapter(value = ["image_src", "placeholder", "is_rounded"], requireAll = false)
    fun setImageUsingGlide(
            imageView: ImageView?,
            imageSrc: String?,
            placeholder: Drawable?,
            isRounded: Boolean
    ) {
        imageView?.let {
            val request: GlideRequest<Drawable> = GlideApp.with(it).load(imageSrc)
            if (placeholder != null) {
                request.placeholder(placeholder)
            }
            if (isRounded) {
                request.apply(RequestOptions().circleCrop())
            }
            request.into(it)
        }
    }
}