package com.softsquared.template.kotlin.src.mycoupon

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.logout.model.LogoutResponse
import com.softsquared.template.kotlin.src.mycoupon.model.MyCouponResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface CouponView{
    fun onGetCouponSuccess(response: MyCouponResponse)
    fun onGetCouponFailure(message: String)
}