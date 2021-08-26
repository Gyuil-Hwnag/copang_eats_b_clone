package com.softsquared.template.kotlin.src.delivery_detail

import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.delivery_detail.model.DeliveryDetailResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DeliveryDetailAPI {
    @GET("app/stores/{userId}/mainstore")
    fun getDeliveryDetail(@Path("userId") userId: Int, @Query("storeId") storeId: Int): Call<DeliveryDetailResponse>
}
