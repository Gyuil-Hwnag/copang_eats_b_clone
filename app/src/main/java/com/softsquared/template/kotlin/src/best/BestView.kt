package com.softsquared.template.kotlin.src.best

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.best.model.BestResponse
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.logout.model.LogoutResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface BestView{
    fun onGetBestSuccess(response: BestResponse)
    fun onGetBestFailure(message: String)
}