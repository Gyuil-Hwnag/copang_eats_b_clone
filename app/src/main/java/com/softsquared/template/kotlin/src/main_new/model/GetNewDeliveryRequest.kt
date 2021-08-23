package com.softsquared.template.kotlin.src.main_new.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Path

data class GetNewDeliveryRequest(
    @Path("userId") val userId: Int
)