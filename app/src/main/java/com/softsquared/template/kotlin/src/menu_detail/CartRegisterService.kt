package com.softsquared.template.kotlin.src.menu_detail

import androidx.appcompat.app.AppCompatActivity
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.menu_detail.model.CartRegisterResponse
import com.softsquared.template.kotlin.src.menu_detail.model.PostCartRegisterRequest
import com.softsquared.template.kotlin.src.register.model.PostRegisterRequest
import com.softsquared.template.kotlin.src.register.model.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartRegisterService(val view: CartRegisterView) {
    fun tryPostLogin(postCartRegisterRequest: PostCartRegisterRequest){
        val cartRegisterAPI = ApplicationClass.sRetrofit.create(CartRegisterAPI::class.java)
        cartRegisterAPI.postCartRegister(postCartRegisterRequest).enqueue(object :
            Callback<BaseResponse> {
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                view.onPostCartRegisterSuccess(response.body() as BaseResponse)
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                view.onPostCartRegisterFailure(t.message ?: "통신 오류")
            }
        })
    }
}