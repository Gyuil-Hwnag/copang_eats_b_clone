package com.softsquared.template.kotlin.src.main_other

import com.softsquared.template.kotlin.src.main_other.model.otherResponse

interface otherView{
    fun onGetOtherSuccess(response: otherResponse)
    fun onGetOtherFailure(message: String)
}