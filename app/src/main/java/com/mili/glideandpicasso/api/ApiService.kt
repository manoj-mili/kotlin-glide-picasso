package com.mili.glideandpicasso.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/?")
    suspend fun getImages(
    @Query("key") apiKey: String,
    @Query("q") query: String,
    @Query("image_type") imageType: String,
    @Query("pretty") yesOrNo: Boolean
    ):ApiResponse
}