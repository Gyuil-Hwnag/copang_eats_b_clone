package com.softsquared.template.kotlin.src.location_detail

import androidx.appcompat.app.AppCompatActivity
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.location_detail.model.LocationDetailResponse
import com.softsquared.template.kotlin.src.location_detail.model.PostLocationDetailRequest
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.register.model.PostRegisterRequest
import com.softsquared.template.kotlin.src.register.model.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationDetailService(val view: LocationDetailView) {
    fun tryPostLocationDetail(userId: Int ,postLocationDetailRequest: PostLocationDetailRequest){
        val LocationDetailapi = ApplicationClass.sRetrofit.create(LocationDetailAPI::class.java)
        LocationDetailapi.postLocationDetail(userId ,postLocationDetailRequest).enqueue(object :
            Callback<LocationDetailResponse> {
            override fun onResponse(call: Call<LocationDetailResponse>, response: Response<LocationDetailResponse>) {
                view.onPostLocationDetailSuccess(response.body() as LocationDetailResponse)
            }

            override fun onFailure(call: Call<LocationDetailResponse>, t: Throwable) {
                view.onPostLocationDetailFailure(t.message ?: "통신 오류")
            }
        })
    }
}