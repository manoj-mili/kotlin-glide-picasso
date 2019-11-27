package com.mili.glideandpicasso.ui.glide

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mili.glideandpicasso.R
import com.mili.glideandpicasso.databinding.ViewGlideImageItemsBinding
import com.mili.glideandpicasso.model.ImageDataModel

class GlideImageAdapter(private val imageDataModelList: List<ImageDataModel>):
    RecyclerView.Adapter<GlideImageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = DataBindingUtil.inflate<ViewGlideImageItemsBinding>(LayoutInflater.from(parent.context),
            R.layout.view_glide_image_items,parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.d("Glide Image ", (imageDataModelList.size).toString())
        return imageDataModelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imageDataModelList.get(position))
    }

    class ViewHolder(private val binding: ViewGlideImageItemsBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(imageDataModel: ImageDataModel) {
            Log.d("Glide Image ",imageDataModel.toString())
            binding.image = imageDataModel
            binding.executePendingBindings()
        }

    }
}