package com.softsquared.template.kotlin.src.event

import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.logout.model.LogoutResponse
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

interface EventView{
    fun onPostEventSuccess(response: EventResponse)
    fun onPostEventFailure(message: String)
}