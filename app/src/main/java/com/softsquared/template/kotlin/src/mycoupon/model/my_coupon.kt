package com.softsquared.template.kotlin.src.mycoupon.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class my_coupon(
    @SerializedName("couponName") val couponName: String,
    @SerializedName("salePrice") val salePrice: Int,
    @SerializedName("limitOrderPrice") val limitOrderPrice: Int,
    @SerializedName("expirationDate") val expirationDate: Date
)