package com.softsquared.template.kotlin.src.register

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface RegisterView{
    fun onPostRegisterSuccess(response: SignUpResponse)
    fun onPostRegisterFailure(message: String)
}