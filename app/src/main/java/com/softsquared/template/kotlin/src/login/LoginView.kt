package com.softsquared.template.kotlin.src.login

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface LoginView{
    fun onPostLoginSuccess(response: LoginResponse)
    fun onPostLoginFailure(message: String)
}