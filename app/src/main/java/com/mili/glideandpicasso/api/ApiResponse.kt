package com.mili.glideandpicasso.api

import com.mili.glideandpicasso.model.ImageDataModel

data class ApiResponse(val totalHits: Int, val hits: List<ImageDataModel>)