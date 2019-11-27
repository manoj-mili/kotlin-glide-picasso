package com.mili.glideandpicasso.ui.glide

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mili.glideandpicasso.api.ApiResponse
import com.mili.glideandpicasso.api.ApiService
import com.mili.glideandpicasso.api.ProvideRetrofit
import com.mili.glideandpicasso.util.Constants.API_KEY
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class GlideViewModel(application: Application) : AndroidViewModel(application) {
    private var apiService: ApiService = ProvideRetrofit.invoke()
    private val apiResponse = MutableLiveData<ApiResponse>()


    fun getImagesForGlideView() {
        CoroutineScope(IO).launch {
            apiResponse.postValue(apiService.getImages(API_KEY,"food","photo",true))
        }
    }

    fun imagesAfterLoad() : LiveData<ApiResponse> {
        return apiResponse
    }
}