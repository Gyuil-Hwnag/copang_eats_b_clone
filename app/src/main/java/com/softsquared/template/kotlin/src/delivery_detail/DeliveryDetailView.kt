package com.softsquared.template.kotlin.src.delivery_detail

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.delivery_detail.model.DeliveryDetailResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.logout.model.LogoutResponse
import com.softsquared.template.kotlin.src.main_loc.model.MainLocResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface DeliveryDetailView{
    fun onGetDeliveryDetailSuccess(response: DeliveryDetailResponse)
    fun onGetDeliveryDetailFailure(message: String)
}