package com.softsquared.template.kotlin.src.search_detail

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import com.softsquared.template.kotlin.src.main_other.model.otherResponse
import com.softsquared.template.kotlin.src.search_detail.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchDetailService(val view: SearchDetailView) {
    fun tryGetSearchDetail(userId: Int, keyword: String){
        val SearchDetailAPI = ApplicationClass.sRetrofit.create(SearchDetailAPI::class.java)
        SearchDetailAPI.getSearchDetail(userId, keyword).enqueue(object :
            Callback<SearchResponse> {
            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                view.onGetSearchDetailSuccess(response.body() as SearchResponse)
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                view.onGetSearchDetailFailure(t.message ?: "통신 오류")
            }
        })
    }
}