package com.softsquared.template.kotlin.src.register

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.register.model.PostRegisterRequest
import com.softsquared.template.kotlin.src.register.model.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface registerAPI {
    @POST("/app/users/sign-up")
    fun postRegister(@Body params: PostRegisterRequest): Call<SignUpResponse>
}