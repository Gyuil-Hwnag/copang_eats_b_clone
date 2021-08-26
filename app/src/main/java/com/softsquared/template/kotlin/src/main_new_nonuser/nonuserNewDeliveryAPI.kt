package com.softsquared.template.kotlin.src.main_new_nonuser

import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface nonuserNewDeliveryAPI {
    @GET("app/stores/main-new")
    fun getNewDelivery(@Query("latitude") latitude: Float,
                       @Query("longitude") longitude: Float): Call<NewDeliveryResponse>
}
