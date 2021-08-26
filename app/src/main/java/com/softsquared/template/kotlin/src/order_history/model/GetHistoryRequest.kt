package com.softsquared.template.kotlin.src.order_history.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Path

data class GetHistoryRequest(
    @Path("userId") val userId: Int
)