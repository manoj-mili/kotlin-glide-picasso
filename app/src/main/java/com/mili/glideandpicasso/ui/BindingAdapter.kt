package com.mili.glideandpicasso.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mili.glideandpicasso.R
import com.squareup.picasso.Picasso

@BindingAdapter("bind:picassoImageUrl")
fun setImageFromPicasso(imageView: ImageView, url: String) {
    Picasso.get().load(url).placeholder(R.drawable.ic_pixabay_logo).fit().centerCrop().into(imageView)
}

@BindingAdapter("bind:glideImageUrl")
fun setImageFromGlide(view: ImageView, url: String) {
    Glide.with(view.context).load(url).placeholder(R.drawable.ic_pixabay_logo).centerCrop().into(view)
}