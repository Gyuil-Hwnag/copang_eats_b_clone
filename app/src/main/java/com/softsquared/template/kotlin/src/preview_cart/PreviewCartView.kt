package com.softsquared.template.kotlin.src.preview_cart

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.logout.model.LogoutResponse
import com.softsquared.template.kotlin.src.mycoupon.model.MyCouponResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface PreviewCartView{
    fun onGetPreviewCartSuccess(response: PreviewCartResponse)
    fun onGetPreviewCartFailure(message: String)
}