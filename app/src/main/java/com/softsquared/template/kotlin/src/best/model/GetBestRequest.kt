package com.softsquared.template.kotlin.src.best.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Path

data class GetBestRequest(
    @Path("userId") val userId: Int
)