package com.softsquared.template.kotlin.src.add_cart

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface AddCartView{
    fun onPostAddCartSuccess(response: AddCartResponse)
    fun onPostAddCartFailure(message: String)
}