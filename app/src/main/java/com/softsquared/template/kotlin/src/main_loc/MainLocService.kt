package com.softsquared.template.kotlin.src.main_loc

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.main_loc.model.MainLocResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainLocService(val view: MainLocView) {
    fun tryGetNewDelivery(userId: Int){
        val mainlocAPI = ApplicationClass.sRetrofit.create(MainLocAPI::class.java)
        mainlocAPI.getNewDelivery(userId).enqueue(object :
            Callback<MainLocResponse> {
            override fun onResponse(call: Call<MainLocResponse>, response: Response<MainLocResponse>) {
                view.onGetMainLocSuccess(response.body() as MainLocResponse)
            }

            override fun onFailure(call: Call<MainLocResponse>, t: Throwable) {
                view.onGetMainLocFailure(t.message ?: "통신 오류")
            }
        })
    }
}