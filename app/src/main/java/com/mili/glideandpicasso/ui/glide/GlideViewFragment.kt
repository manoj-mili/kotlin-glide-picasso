package com.mili.glideandpicasso.ui.glide


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson

import com.mili.glideandpicasso.R
import com.mili.glideandpicasso.databinding.FragmentGlideViewBinding
import com.mili.glideandpicasso.model.ImageDataModel
import com.mili.glideandpicasso.ui.picasso.PicassoViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass.
 */
class GlideViewFragment : Fragment() {
    private lateinit var binding: FragmentGlideViewBinding
    private lateinit var glideViewModel: GlideViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_glide_view, container, false)
        glideViewModel = ViewModelProviders.of(this).get(GlideViewModel::class.java)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeImageChanges()

    }

    private fun observeImageChanges() {
        glideViewModel.getImagesForGlideView()
        glideViewModel.imagesAfterLoad().observe(this, Observer {
            updateAdapter(it.hits)
        })
    }

    private fun updateAdapter(imageDataModelList: List<ImageDataModel>) {
        val adapter = GlideImageAdapter(imageDataModelList)
        binding.adapter  = adapter
        adapter.notifyDataSetChanged()
    }


}
