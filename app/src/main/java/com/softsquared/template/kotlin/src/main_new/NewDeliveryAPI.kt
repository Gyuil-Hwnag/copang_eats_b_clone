package com.softsquared.template.kotlin.src.main_new

import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NewDeliveryAPI {
    @GET("app/stores/{userId}/main-new")
    fun getNewDelivery(@Path("userId") userId: Int): Call<NewDeliveryResponse>
}
