package com.softsquared.template.kotlin.src.mycoupon.couponRegister

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.model.CouponRegisterResponse
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.model.PostCouponRegisterRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRegisterService(val view: CouponRegisterView) {
    fun tryPostCouponRegister(userId: Int, postCouponRegisRequest: PostCouponRegisterRequest){
        val couponRegisterAPI = ApplicationClass.sRetrofit.create(CouponRegisterAPI::class.java)
        couponRegisterAPI.postCouponRegister(userId, postCouponRegisRequest).enqueue(object :
            Callback<CouponRegisterResponse> {
            override fun onResponse(call: Call<CouponRegisterResponse>, response: Response<CouponRegisterResponse>) {
                view.onPostCouponRegisterSuccess(response.body() as CouponRegisterResponse)
            }

            override fun onFailure(call: Call<CouponRegisterResponse>, t: Throwable) {
                view.onPostCouponRegisterFailure(t.message ?: "통신 오류")
            }
        })
    }
}