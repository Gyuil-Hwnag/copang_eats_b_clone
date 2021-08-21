package com.softsquared.template.kotlin.src.mycoupon.couponRegister

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.logout.model.LogoutResponse
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.model.CouponRegisterResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface CouponRegisterView{
    fun onPostCouponRegisterSuccess(response: CouponRegisterResponse)
    fun onPostCouponRegisterFailure(message: String)
}