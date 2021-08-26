package com.softsquared.template.kotlin.src.main_other_nonuser

import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import com.softsquared.template.kotlin.src.main_other.model.otherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface nonuserOtherAPI {
    @GET("app/stores/main-pick")
    fun getOther(@Query("latitude") latitude: Float,
                 @Query("longitude") longitude: Float): Call<otherResponse>
}
