package com.softsquared.template.kotlin.src.menu_detail

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.menu_detail.model.CartRegisterResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface CartRegisterView{
    fun onPostCartRegisterSuccess(response: CartRegisterResponse)
    fun onPostCartRegisterFailure(message: String)
}