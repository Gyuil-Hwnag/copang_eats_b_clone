package com.softsquared.template.kotlin.src.best_nonuser

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.best.model.BestResponse
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class nonuserBestService(val view: nonuserBestView) {
    fun tryGetBest(latitude: Float, longitude: Float){
        val bestAPI = ApplicationClass.sRetrofit.create(nonuserBestAPI::class.java)
        bestAPI.getBest(latitude, longitude).enqueue(object :
            Callback<BestResponse> {
            override fun onResponse(call: Call<BestResponse>, response: Response<BestResponse>) {
                view.onGetnonuserBestSuccess(response.body() as BestResponse)
            }

            override fun onFailure(call: Call<BestResponse>, t: Throwable) {
                view.onGetnonuserBestFailure(t.message ?: "통신 오류")
            }
        })
    }
}