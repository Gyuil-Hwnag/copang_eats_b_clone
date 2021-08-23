package com.softsquared.template.kotlin.src.mypage

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.main_loc.model.MainLocResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import com.softsquared.template.kotlin.src.mypage.model.UserInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserInfoService(val view: UserInfoView) {
    fun tryGetNewDelivery(userId: Int){
        val userinfoAPI = ApplicationClass.sRetrofit.create(UserInfoAPI::class.java)
        userinfoAPI.getUserInfo(userId).enqueue(object :
            Callback<UserInfoResponse> {
            override fun onResponse(call: Call<UserInfoResponse>, response: Response<UserInfoResponse>) {
                view.onGetUserInfoSuccess(response.body() as UserInfoResponse)
            }

            override fun onFailure(call: Call<UserInfoResponse>, t: Throwable) {
                view.onGetUserInfoFailure(t.message ?: "통신 오류")
            }
        })
    }
}