package com.softsquared.template.kotlin.src.delivery_detail

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.delivery_detail.model.DeliveryDetailResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.main_loc.model.MainLocResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeliveryDetailService(val view: DeliveryDetailView) {
    fun tryGetDeliveryDetail(userId: Int, storeId: Int){
        val deliveryDetailAPI = ApplicationClass.sRetrofit.create(DeliveryDetailAPI::class.java)
        deliveryDetailAPI.getDeliveryDetail(userId, storeId).enqueue(object :
            Callback<DeliveryDetailResponse> {
            override fun onResponse(call: Call<DeliveryDetailResponse>, response: Response<DeliveryDetailResponse>) {
                view.onGetDeliveryDetailSuccess(response.body() as DeliveryDetailResponse)
            }

            override fun onFailure(call: Call<DeliveryDetailResponse>, t: Throwable) {
                view.onGetDeliveryDetailFailure(t.message ?: "통신 오류")
            }
        })
    }
}