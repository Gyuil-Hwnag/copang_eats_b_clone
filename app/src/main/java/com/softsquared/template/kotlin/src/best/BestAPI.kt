package com.softsquared.template.kotlin.src.best

import com.softsquared.template.kotlin.src.best.model.BestResponse
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BestAPI {
    @GET("app/stores/{userId}/main")
    fun getBest(@Path("userId") userId: Int): Call<BestResponse>
}
