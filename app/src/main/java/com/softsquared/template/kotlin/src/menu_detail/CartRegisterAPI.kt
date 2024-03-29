package com.softsquared.template.kotlin.src.menu_detail

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.menu_detail.model.CartRegisterResponse
import com.softsquared.template.kotlin.src.menu_detail.model.PostCartRegisterRequest
import com.softsquared.template.kotlin.src.register.model.PostRegisterRequest
import com.softsquared.template.kotlin.src.register.model.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface CartRegisterAPI {
    @POST("app/orders/in-cart")
    fun postCartRegister(@Body params: PostCartRegisterRequest): Call<BaseResponse>
}