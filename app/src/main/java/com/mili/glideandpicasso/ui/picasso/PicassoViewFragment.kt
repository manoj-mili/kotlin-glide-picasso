package com.mili.glideandpicasso.ui.picasso


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mili.glideandpicasso.R
import com.mili.glideandpicasso.databinding.FragmentPicassoViewBinding
import com.mili.glideandpicasso.model.ImageDataModel

/**
 * A simple [Fragment] subclass.
 */
class PicassoViewFragment : Fragment() {
    private lateinit var binding: FragmentPicassoViewBinding
    private lateinit var viewModel: PicassoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_picasso_view, container, false)
        viewModel = ViewModelProviders.of(this).get(PicassoViewModel::class.java)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeImageChanges()

    }

    private fun observeImageChanges() {
        viewModel.getImagesForPicassoView()

        viewModel.imagesAfterLoad().observe(this, Observer {
            updateAdapter(it.hits)
        })
    }

    private fun updateAdapter(imageDataModelList: List<ImageDataModel>) {
        val adapter = PicassoImageAdapter(imageDataModelList)
        binding.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}
