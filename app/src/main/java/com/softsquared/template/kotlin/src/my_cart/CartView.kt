package com.softsquared.template.kotlin.src.my_cart

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.logout.model.LogoutResponse
import com.softsquared.template.kotlin.src.my_cart.model.CartResponse
import com.softsquared.template.kotlin.src.mycoupon.model.MyCouponResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface CartView{
    fun onGetCartSuccess(response: CartResponse)
    fun onGetCartFailure(message: String)
}