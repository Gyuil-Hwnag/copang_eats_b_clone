package com.softsquared.template.kotlin.src.map

import androidx.appcompat.app.AppCompatActivity
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.map.model.RegisterLocationRequest
import com.softsquared.template.kotlin.src.menu_detail.model.CartRegisterResponse
import com.softsquared.template.kotlin.src.menu_detail.model.PostCartRegisterRequest
import com.softsquared.template.kotlin.src.register.model.PostRegisterRequest
import com.softsquared.template.kotlin.src.register.model.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterLocationService(val view: RegisterLocationView) {
    fun tryPostLogin(RegisterLocationRequest: RegisterLocationRequest){
        val RegisterLocationAPI = ApplicationClass.sRetrofit.create(RegisterLocationAPI::class.java)
        RegisterLocationAPI.postCartRegister(RegisterLocationRequest).enqueue(object :
            Callback<BaseResponse> {
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                view.onPostRegisterLocationSuccess(response.body() as BaseResponse)
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                view.onPostRegisterLocationFailure(t.message ?: "통신 오류")
            }
        })
    }
}