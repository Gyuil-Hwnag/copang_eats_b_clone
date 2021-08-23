package com.softsquared.template.kotlin.src.main_other

import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import com.softsquared.template.kotlin.src.main_other.model.otherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface OtherAPI {
    @GET("app/stores/{userId}/main-pick")
    fun getOther(@Path("userId") userId: Int): Call<otherResponse>
}
