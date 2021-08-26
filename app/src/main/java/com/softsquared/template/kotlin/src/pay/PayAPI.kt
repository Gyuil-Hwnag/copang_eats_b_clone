package com.softsquared.template.kotlin.src.pay

import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.pay.model.PayResponse
import com.softsquared.template.kotlin.src.pay.model.PostPayRequest
import com.softsquared.template.kotlin.src.register.model.PostRegisterRequest
import com.softsquared.template.kotlin.src.register.model.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface PayAPI {
    @POST("/app/orders/{userId}/payment")
    fun postPay(@Path("userId") userId: Int, @Body params: PostPayRequest): Call<PayResponse>
}