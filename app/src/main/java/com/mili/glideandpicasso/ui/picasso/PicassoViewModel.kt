package com.mili.glideandpicasso.ui.picasso

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mili.glideandpicasso.api.ApiResponse
import com.mili.glideandpicasso.api.ApiService
import com.mili.glideandpicasso.api.ProvideRetrofit
import com.mili.glideandpicasso.util.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PicassoViewModel(application: Application) : AndroidViewModel(application) {

    private var apiService: ApiService = ProvideRetrofit.invoke()
    private val apiResponse = MutableLiveData<ApiResponse>()

    fun getImagesForPicassoView() {
        CoroutineScope(Dispatchers.IO).launch {
            apiResponse.postValue(apiService.getImages(Constants.API_KEY,"food","photo",true))
        }
    }


    fun imagesAfterLoad() : LiveData<ApiResponse> {
        return apiResponse
    }
}