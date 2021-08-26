package com.softsquared.template.kotlin.src.add_cart

import androidx.appcompat.app.AppCompatActivity
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.register.model.PostRegisterRequest
import com.softsquared.template.kotlin.src.register.model.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddCartService(val view: AddCartView) {
    fun tryPostAddCart(userId: Int, postAddCartRequest: AddCartRequest){
        val AddCartAPI = ApplicationClass.sRetrofit.create(AddCartAPI::class.java)
        AddCartAPI.postRegister(userId ,postAddCartRequest).enqueue(object :
            Callback<AddCartResponse> {
            override fun onResponse(call: Call<AddCartResponse>, response: Response<AddCartResponse>) {
                view.onPostAddCartSuccess(response.body() as AddCartResponse)
            }

            override fun onFailure(call: Call<AddCartResponse>, t: Throwable) {
                view.onPostAddCartFailure(t.message ?: "통신 오류")
            }
        })
    }
}