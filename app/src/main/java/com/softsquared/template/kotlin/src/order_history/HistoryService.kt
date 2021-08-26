package com.softsquared.template.kotlin.src.order_history

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.mycoupon.model.MyCouponResponse
import com.softsquared.template.kotlin.src.order_history.model.HistoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryService(val view: HistoryView) {
    fun tryGetMyCoupon(userId: Int){
        val historyAPI = ApplicationClass.sRetrofit.create(HistoryAPI::class.java)
        historyAPI.getHistory(userId).enqueue(object :
            Callback<HistoryResponse> {
            override fun onResponse(call: Call<HistoryResponse>, response: Response<HistoryResponse>) {
                view.onGetHistorySuccess(response.body() as HistoryResponse)
            }

            override fun onFailure(call: Call<HistoryResponse>, t: Throwable) {
                view.onGetHistoryFailure(t.message ?: "통신 오류")
            }
        })
    }
}