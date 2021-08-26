package com.softsquared.template.kotlin.src.pay

import androidx.appcompat.app.AppCompatActivity
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.pay.model.PayResponse
import com.softsquared.template.kotlin.src.pay.model.PostPayRequest
import com.softsquared.template.kotlin.src.register.model.PostRegisterRequest
import com.softsquared.template.kotlin.src.register.model.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PayService(val view: PayView) {
    fun tryPostPay(userId: Int, postPayRequest: PostPayRequest){
        val payAPI = ApplicationClass.sRetrofit.create(PayAPI::class.java)
        payAPI.postPay(userId, postPayRequest).enqueue(object :
            Callback<PayResponse> {
            override fun onResponse(call: Call<PayResponse>, response: Response<PayResponse>) {
                view.onPostPaySuccess(response.body() as PayResponse)
            }

            override fun onFailure(call: Call<PayResponse>, t: Throwable) {
                view.onPostPayFailure(t.message ?: "통신 오류")
            }
        })
    }
}