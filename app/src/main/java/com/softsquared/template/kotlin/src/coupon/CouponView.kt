package com.softsquared.template.kotlin.src.coupon

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.logout.model.LogoutResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface CouponView{
    fun onGetCouponSuccess(response: CouponResponse)
    fun onGetCouponFailure(message: String)
}