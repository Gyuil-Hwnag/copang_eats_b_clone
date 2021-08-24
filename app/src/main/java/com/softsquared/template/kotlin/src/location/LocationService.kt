package com.softsquared.template.kotlin.src.location

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.location.model.LocationResponse
import com.softsquared.template.kotlin.src.main_loc.model.MainLocResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationService(val view: LocationView) {
    fun tryGetLocation(userId: Int){
        val locationAPI = ApplicationClass.sRetrofit.create(LocationAPI::class.java)
        locationAPI.getLocation(userId).enqueue(object :
            Callback<LocationResponse> {
            override fun onResponse(call: Call<LocationResponse>, response: Response<LocationResponse>) {
                view.onGetLocationSuccess(response.body() as LocationResponse)
            }

            override fun onFailure(call: Call<LocationResponse>, t: Throwable) {
                view.onGetLocationFailure(t.message ?: "통신 오류")
            }
        })
    }
}