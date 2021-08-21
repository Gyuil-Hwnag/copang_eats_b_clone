package com.softsquared.template.kotlin.src.coupon.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Path

data class GetCouponRequest(
    @Path("userId") val userId: Int
)