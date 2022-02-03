package com.softsquared.template.kotlin.src.my_cart

import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.my_cart.model.CartResponse
import com.softsquared.template.kotlin.src.mycoupon.model.MyCouponResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CartAPI {
    @GET("app/orders/{userId}/in-cart")
    fun getCart(@Path("userId") userId: Int): Call<CartResponse>
}
