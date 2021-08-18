package com.softsquared.template.kotlin.src.login.model

import com.google.gson.annotations.SerializedName

data class ResultLogin(
        @SerializedName("userId") val userId: Int,
        @SerializedName("jwt") val jwt: String
)