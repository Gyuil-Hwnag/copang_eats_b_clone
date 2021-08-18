package com.softsquared.template.kotlin.src.register

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.register.model.PostRegisterRequest
import com.softsquared.template.kotlin.src.register.model.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterService(val view: RegisterView) {
    fun tryPostRegisterUp(postRegisterRequest: PostRegisterRequest){
        val registerAPI = ApplicationClass.sRetrofit.create(registerAPI::class.java)
        registerAPI.postRegister(postRegisterRequest).enqueue(object :
            Callback<SignUpResponse> {
            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                view.onPostRegisterSuccess(response.body() as SignUpResponse)
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                view.onPostRegisterFailure(t.message ?: "통신 오류")
            }
        })
    }
}