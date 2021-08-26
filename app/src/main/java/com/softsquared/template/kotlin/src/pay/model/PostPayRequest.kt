package com.softsquared.template.kotlin.src.pay.model

import com.google.gson.annotations.SerializedName

data class PostPayRequest(
    @SerializedName("storeMessage") val storeMessage: String,
    @SerializedName("deliveryMessage") val deliveryMessage: String
)