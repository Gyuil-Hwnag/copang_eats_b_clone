package com.softsquared.template.kotlin.src.login

import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.register.model.PostRegisterRequest
import com.softsquared.template.kotlin.src.register.model.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginAPI {
    @POST("/app/login")
    fun postRegister(@Body params: PostLoginRequest): Call<LoginResponse>
}