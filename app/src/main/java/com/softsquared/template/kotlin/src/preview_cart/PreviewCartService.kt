package com.softsquared.template.kotlin.src.preview_cart

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.mycoupon.model.MyCouponResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PreviewCartService(val view: PreviewCartView) {
    fun tryGetPreviewCart(userId: Int){
        val previewcartAPI = ApplicationClass.sRetrofit.create(PreviewCartAPI::class.java)
        previewcartAPI.getPreviewCart(userId).enqueue(object :
            Callback<PreviewCartResponse> {
            override fun onResponse(call: Call<PreviewCartResponse>, response: Response<PreviewCartResponse>) {
                view.onGetPreviewCartSuccess(response.body() as PreviewCartResponse)
            }

            override fun onFailure(call: Call<PreviewCartResponse>, t: Throwable) {
                view.onGetPreviewCartFailure(t.message ?: "통신 오류")
            }
        })
    }
}