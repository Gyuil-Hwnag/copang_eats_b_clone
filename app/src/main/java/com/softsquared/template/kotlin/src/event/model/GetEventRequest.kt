package com.softsquared.template.kotlin.src.event.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Path

data class GetEventRequest(
    @Path("userId") val userId: Int
)