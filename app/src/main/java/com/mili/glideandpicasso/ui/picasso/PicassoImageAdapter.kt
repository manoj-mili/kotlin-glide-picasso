package com.mili.glideandpicasso.ui.picasso

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mili.glideandpicasso.R
import com.mili.glideandpicasso.databinding.ViewPicassoImageItemsBinding
import com.mili.glideandpicasso.model.ImageDataModel

class PicassoImageAdapter(private val imageDataModelList: List<ImageDataModel>):
    RecyclerView.Adapter<PicassoImageAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ViewPicassoImageItemsBinding>(LayoutInflater.from(parent.context), R.layout.view_picasso_image_items, parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return imageDataModelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imageDataModelList.get(position))
    }

    class ViewHolder(private val binding: ViewPicassoImageItemsBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(imageDataModel: ImageDataModel){
            binding.image = imageDataModel
            binding.executePendingBindings()
        }
    }
}