package com.softsquared.template.kotlin.src.delivery_detail.model

import com.google.gson.annotations.SerializedName

data class review(
    @SerializedName("reviewImg") val reviewImg: String,
    @SerializedName("reviewTxt") val reviewTxt: String,
    @SerializedName("averageingStar") val averageingStar: Float
)