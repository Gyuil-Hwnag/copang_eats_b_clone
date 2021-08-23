package com.softsquared.template.kotlin.src.location_detail

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.location_detail.model.LocationDetailResponse
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface LocationDetailView{
    fun onPostLocationDetailSuccess(response: LocationDetailResponse)
    fun onPostLocationDetailFailure(message: String)
}