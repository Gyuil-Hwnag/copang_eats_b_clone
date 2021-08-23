package com.softsquared.template.kotlin.src.location_detail.model

import com.google.gson.annotations.SerializedName

data class ResultLocationDetail(
        @SerializedName("userId") val userId: Int,
        @SerializedName("jwt") val jwt: String
)