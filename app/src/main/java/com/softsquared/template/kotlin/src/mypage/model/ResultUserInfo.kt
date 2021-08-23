package com.softsquared.template.kotlin.src.mypage.model

import com.google.gson.annotations.SerializedName

data class ResultUserInfo(
    @SerializedName("userName") val userName: String,
    @SerializedName("PhoneNumber") val PhoneNumber: String
)