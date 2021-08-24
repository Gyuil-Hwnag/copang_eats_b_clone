package com.softsquared.template.kotlin.src.mylike

import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import com.softsquared.template.kotlin.src.main_other.model.otherResponse
import com.softsquared.template.kotlin.src.mylike.model.mylikeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface mylikeAPI {
    @GET("app/users/{userId}/bookmark")
    fun getOther(@Path("userId") userId: Int, @Query("filter") filter: String): Call<mylikeResponse>
}
