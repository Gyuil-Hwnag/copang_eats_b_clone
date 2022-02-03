package com.softsquared.template.kotlin.src.map

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.menu_detail.model.CartRegisterResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface RegisterLocationView{
    fun onPostRegisterLocationSuccess(response: BaseResponse)
    fun onPostRegisterLocationFailure(message: String)
}