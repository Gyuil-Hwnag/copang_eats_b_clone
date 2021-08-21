package com.softsquared.template.kotlin.src.coupon

import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface couponAPI {
    @GET("app/events/{userId}/coupon")
    fun getCoupon(@Path("userId") userId: Int): Call<CouponResponse>
}
