package com.softsquared.template.kotlin.src.search_detail.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Path
import retrofit2.http.Query

data class GetSearchRequest(
    @Path("userId") val userId: Int,
    @Query("keyword") val keyword: String
)