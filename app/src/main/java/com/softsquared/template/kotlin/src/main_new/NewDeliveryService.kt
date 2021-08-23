package com.softsquared.template.kotlin.src.main_new

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewDeliveryService(val view: NewDeliveryView) {
    fun tryGetNewDelivery(userId: Int){
        val newdeliveryAPI = ApplicationClass.sRetrofit.create(NewDeliveryAPI::class.java)
        newdeliveryAPI.getNewDelivery(userId).enqueue(object :
            Callback<NewDeliveryResponse> {
            override fun onResponse(call: Call<NewDeliveryResponse>, response: Response<NewDeliveryResponse>) {
                view.onGetNewDeliverySuccess(response.body() as NewDeliveryResponse)
            }

            override fun onFailure(call: Call<NewDeliveryResponse>, t: Throwable) {
                view.onGetNewDeliveryFailure(t.message ?: "통신 오류")
            }
        })
    }
}