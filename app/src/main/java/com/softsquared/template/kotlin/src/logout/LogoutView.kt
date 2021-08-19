package com.softsquared.template.kotlin.src.logout

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.logout.model.LogoutResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface LogoutView{
    fun onPostLogoutSuccess(response: LogoutResponse)
    fun onPostLogoutFailure(message: String)
}