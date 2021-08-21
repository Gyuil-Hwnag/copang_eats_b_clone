package com.softsquared.template.kotlin.src.mycoupon

import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.mycoupon.model.MyCouponResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface mycouponAPI {
    @GET("/app/users/{userId}/coupon")
    fun getMyCoupon(@Path("userId") userId: Int): Call<MyCouponResponse>
}
