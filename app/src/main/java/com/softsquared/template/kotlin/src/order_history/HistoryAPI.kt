package com.softsquared.template.kotlin.src.order_history

import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.mycoupon.model.MyCouponResponse
import com.softsquared.template.kotlin.src.order_history.model.HistoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HistoryAPI {
    @GET("/app/orders/{userId}/history")
    fun getHistory(@Path("userId") userId: Int): Call<HistoryResponse>
}
