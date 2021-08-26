package com.softsquared.template.kotlin.src.main_other_nonuser

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import com.softsquared.template.kotlin.src.main_other.model.otherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class nonuserotherService(val view: nonuserotherView) {
    fun tryGetOther(latitude: Float, longitude: Float){
        val otherAPI = ApplicationClass.sRetrofit.create(nonuserOtherAPI::class.java)
        otherAPI.getOther(latitude, longitude).enqueue(object :
            Callback<otherResponse> {
            override fun onResponse(call: Call<otherResponse>, response: Response<otherResponse>) {
                view.onGetnonuserOtherSuccess(response.body() as otherResponse)
            }

            override fun onFailure(call: Call<otherResponse>, t: Throwable) {
                view.onGetnonuserOtherFailure(t.message ?: "통신 오류")
            }
        })
    }
}