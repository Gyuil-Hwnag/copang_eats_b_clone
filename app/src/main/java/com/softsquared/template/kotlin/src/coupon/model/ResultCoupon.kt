package com.softsquared.template.kotlin.src.coupon.model

import com.google.gson.annotations.SerializedName

data class ResultCoupon(
        @SerializedName("storeName") val storeName: String,
        @SerializedName("storeImageUrl") val storeImageUrl: String,
        @SerializedName("salePrice") val salePrice: Int
)