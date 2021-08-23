package com.softsquared.template.kotlin.src.search_detail

import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import com.softsquared.template.kotlin.src.main_other.model.otherResponse
import com.softsquared.template.kotlin.src.search_detail.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SearchDetailAPI {
    @GET("app/stores/{userId}/keyword")
    fun getSearchDetail(@Path("userId") userId: Int,
                 @Query("keyword") keyword: String): Call<SearchResponse>
}
