package com.softsquared.template.kotlin.src.preview_cart

import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.mycoupon.model.MyCouponResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PreviewCartAPI {
    @GET("/app/orders/{userId}/preview-cart")
    fun getPreviewCart(@Path("userId") userId: Int): Call<PreviewCartResponse>
}
