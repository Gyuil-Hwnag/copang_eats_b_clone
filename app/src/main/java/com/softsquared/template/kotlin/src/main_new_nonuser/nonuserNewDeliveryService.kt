package com.softsquared.template.kotlin.src.main_new_nonuser

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class nonuserNewDeliveryService(val view: nonuserNewDeliveryView) {
    fun tryGetNewDelivery(latitude: Float, longitude: Float){
        val newdeliveryAPI = ApplicationClass.sRetrofit.create(nonuserNewDeliveryAPI::class.java)
        newdeliveryAPI.getNewDelivery(latitude, longitude).enqueue(object :
            Callback<NewDeliveryResponse> {
            override fun onResponse(call: Call<NewDeliveryResponse>, response: Response<NewDeliveryResponse>) {
                view.onGetnonuserNewDeliverySuccess(response.body() as NewDeliveryResponse)
            }

            override fun onFailure(call: Call<NewDeliveryResponse>, t: Throwable) {
                view.onGetnonuserNewDeliveryFailure(t.message ?: "통신 오류")
            }
        })
    }
}