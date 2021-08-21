package com.softsquared.template.kotlin.src.event.model

import com.google.gson.annotations.SerializedName

data class ResultEvent(
        @SerializedName("eventImageUrl") val eventImageUrl: String,
        @SerializedName("eventCount") val eventCount: String
)