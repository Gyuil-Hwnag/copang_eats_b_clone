package com.softsquared.template.kotlin.src.mycoupon.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class my_coupon(
    @SerializedName("couponName") val couponName: String,
    @SerializedName("salePrice") val salePrice: String,
    @SerializedName("limitOrderPrice") val limitOrderPrice: String,
    @SerializedName("expirationDate") val expirationDate: String
)