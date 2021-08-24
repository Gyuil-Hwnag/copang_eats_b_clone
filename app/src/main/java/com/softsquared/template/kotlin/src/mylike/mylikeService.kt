package com.softsquared.template.kotlin.src.mylike

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import com.softsquared.template.kotlin.src.main_other.model.otherResponse
import com.softsquared.template.kotlin.src.mylike.model.mylikeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class mylikeService(val view: mylikeView) {
    fun tryGetmylike(userId: Int, filter: String){
        val mylikeAPI = ApplicationClass.sRetrofit.create(mylikeAPI::class.java)
        mylikeAPI.getOther(userId, filter).enqueue(object :
            Callback<mylikeResponse> {
            override fun onResponse(call: Call<mylikeResponse>, response: Response<mylikeResponse>) {
                view.onGetmylikeSuccess(response.body() as mylikeResponse)
            }

            override fun onFailure(call: Call<mylikeResponse>, t: Throwable) {
                view.onGetmylikeFailure(t.message ?: "통신 오류")
            }
        })
    }
}