package com.softsquared.template.kotlin.src.location

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.location.model.LocationResponse
import com.softsquared.template.kotlin.src.logout.model.LogoutResponse
import com.softsquared.template.kotlin.src.main_loc.model.MainLocResponse
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface LocationView{
    fun onGetLocationSuccess(response: LocationResponse)
    fun onGetLocationFailure(message: String)
}