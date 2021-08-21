package com.softsquared.template.kotlin.src.best

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.best.model.BestResponse
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BestService(val view: BestView) {
    fun tryGetBest(userId: Int){
        val bestAPI = ApplicationClass.sRetrofit.create(BestAPI::class.java)
        bestAPI.getBest(userId).enqueue(object :
            Callback<BestResponse> {
            override fun onResponse(call: Call<BestResponse>, response: Response<BestResponse>) {
                view.onGetBestSuccess(response.body() as BestResponse)
            }

            override fun onFailure(call: Call<BestResponse>, t: Throwable) {
                view.onGetBestFailure(t.message ?: "통신 오류")
            }
        })
    }
}