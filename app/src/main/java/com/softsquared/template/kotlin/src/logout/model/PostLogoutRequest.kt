package com.softsquared.template.kotlin.src.logout.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Path

data class PostLogoutRequest(
    @Path("userId") val userId: Int
)