package com.softsquared.template.kotlin.src.add_cart

import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.register.model.PostRegisterRequest
import com.softsquared.template.kotlin.src.register.model.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface AddCartAPI {
    @POST("/app/orders/{userId}/in-cart")
    fun postRegister(@Path("userId") userId: Int, @Body params: AddCartRequest): Call<AddCartResponse>
}