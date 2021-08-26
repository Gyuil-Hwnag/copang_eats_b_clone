package com.softsquared.template.kotlin.src.pay

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.pay.model.PayResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface PayView{
    fun onPostPaySuccess(response: PayResponse)
    fun onPostPayFailure(message: String)
}