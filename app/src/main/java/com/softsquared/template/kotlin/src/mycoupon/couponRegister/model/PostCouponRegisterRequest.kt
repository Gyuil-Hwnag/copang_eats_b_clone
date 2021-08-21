package com.softsquared.template.kotlin.src.mycoupon.couponRegister.model

import com.google.gson.annotations.SerializedName

data class PostCouponRegisterRequest(
    @SerializedName("couponId") val couponId: Int
)