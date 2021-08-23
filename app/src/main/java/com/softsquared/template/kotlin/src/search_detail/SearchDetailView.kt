package com.softsquared.template.kotlin.src.search_detail

import com.softsquared.template.kotlin.src.main_other.model.otherResponse
import com.softsquared.template.kotlin.src.search_detail.model.SearchResponse

interface SearchDetailView{
    fun onGetSearchDetailSuccess(response: SearchResponse)
    fun onGetSearchDetailFailure(message: String)
}