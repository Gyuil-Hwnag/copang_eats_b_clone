package com.softsquared.template.kotlin.src.mylike.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Path

data class GetmylikeRequest(
    @Path("userId") val userId: Int
)