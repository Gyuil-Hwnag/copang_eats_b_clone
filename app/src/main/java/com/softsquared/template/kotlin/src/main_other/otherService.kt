package com.softsquared.template.kotlin.src.main_other

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import com.softsquared.template.kotlin.src.main_other.model.otherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class otherService(val view: otherView) {
    fun tryGetOther(userId: Int){
        val otherAPI = ApplicationClass.sRetrofit.create(OtherAPI::class.java)
        otherAPI.getOther(userId).enqueue(object :
            Callback<otherResponse> {
            override fun onResponse(call: Call<otherResponse>, response: Response<otherResponse>) {
                view.onGetOtherSuccess(response.body() as otherResponse)
            }

            override fun onFailure(call: Call<otherResponse>, t: Throwable) {
                view.onGetOtherFailure(t.message ?: "통신 오류")
            }
        })
    }
}