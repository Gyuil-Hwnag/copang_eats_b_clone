package com.softsquared.template.kotlin.src.event.model

import com.google.gson.annotations.SerializedName

data class event(
    @SerializedName("eventImageUrl") val eventImageUrl: String,
    @SerializedName("eventCount") val eventCount: Int
)