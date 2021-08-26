package com.softsquared.template.kotlin.src.best_nonuser

import com.softsquared.template.kotlin.src.best.model.BestResponse
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface nonuserBestAPI {
    @GET("app/stores/main-popular")
    fun getBest(@Query("latitude") latitude: Float,
                @Query("longitude") longitude: Float): Call<BestResponse>
}
