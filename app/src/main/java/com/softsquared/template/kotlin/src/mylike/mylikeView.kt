package com.softsquared.template.kotlin.src.mylike

import com.softsquared.template.kotlin.src.main_other.model.otherResponse
import com.softsquared.template.kotlin.src.mylike.model.mylikeResponse

interface mylikeView{
    fun onGetmylikeSuccess(response: mylikeResponse)
    fun onGetmylikeFailure(message: String)
}