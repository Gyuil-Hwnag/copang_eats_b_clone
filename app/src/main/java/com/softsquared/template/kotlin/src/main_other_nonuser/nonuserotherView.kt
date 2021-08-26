package com.softsquared.template.kotlin.src.main_other_nonuser

import com.softsquared.template.kotlin.src.main_other.model.otherResponse

interface nonuserotherView{
    fun onGetnonuserOtherSuccess(response: otherResponse)
    fun onGetnonuserOtherFailure(message: String)
}