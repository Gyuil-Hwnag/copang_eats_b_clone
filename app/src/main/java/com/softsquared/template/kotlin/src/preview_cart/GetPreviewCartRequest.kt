package com.softsquared.template.kotlin.src.preview_cart

import com.google.gson.annotations.SerializedName
import retrofit2.http.Path

data class GetPreviewCartRequest(
    @Path("userId") val userId: Int
)