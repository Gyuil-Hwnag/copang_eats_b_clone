package com.softsquared.template.kotlin.src.mypage.model

import com.google.gson.annotations.SerializedName

data class user_info(
    @SerializedName("userName") val userName: String,
    @SerializedName("PhoneNumber") val PhoneNumber: String
)