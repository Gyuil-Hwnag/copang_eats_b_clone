package com.softsquared.template.kotlin.src.mycoupon

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.mycoupon.model.MyCouponResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponService(val view: CouponView) {
    fun tryGetMyCoupon(userId: Int){
        val mycouponAPI = ApplicationClass.sRetrofit.create(mycouponAPI::class.java)
        mycouponAPI.getMyCoupon(userId).enqueue(object :
            Callback<MyCouponResponse> {
            override fun onResponse(call: Call<MyCouponResponse>, response: Response<MyCouponResponse>) {
                view.onGetCouponSuccess(response.body() as MyCouponResponse)
            }

            override fun onFailure(call: Call<MyCouponResponse>, t: Throwable) {
                view.onGetCouponFailure(t.message ?: "통신 오류")
            }
        })
    }
}