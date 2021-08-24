package com.softsquared.template.kotlin.src.location.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Path

data class LocationRequest(
    @Path("userId") val userId: Int
)