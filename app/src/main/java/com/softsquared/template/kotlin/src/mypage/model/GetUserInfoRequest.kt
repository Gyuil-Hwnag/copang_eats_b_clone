package com.softsquared.template.kotlin.src.mypage.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Path

data class GetUserInfoRequest(
    @Path("userId") val userId: Int
)