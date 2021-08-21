package com.softsquared.template.kotlin.src.coupon

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponService(val view: CouponView) {
    fun tryGetCoupon(userId: Int){
        val couponAPI = ApplicationClass.sRetrofit.create(couponAPI::class.java)
        couponAPI.getCoupon(userId).enqueue(object :
            Callback<CouponResponse> {
            override fun onResponse(call: Call<CouponResponse>, response: Response<CouponResponse>) {
                view.onGetCouponSuccess(response.body() as CouponResponse)
            }

            override fun onFailure(call: Call<CouponResponse>, t: Throwable) {
                view.onGetCouponFailure(t.message ?: "통신 오류")
            }
        })
    }
}