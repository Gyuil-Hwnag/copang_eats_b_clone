package com.softsquared.template.kotlin.src.order_history

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.logout.model.LogoutResponse
import com.softsquared.template.kotlin.src.mycoupon.model.MyCouponResponse
import com.softsquared.template.kotlin.src.order_history.model.HistoryResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface HistoryView{
    fun onGetHistorySuccess(response: HistoryResponse)
    fun onGetHistoryFailure(message: String)
}