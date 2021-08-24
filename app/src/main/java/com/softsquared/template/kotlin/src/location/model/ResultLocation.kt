package com.softsquared.template.kotlin.src.location.model

import com.google.gson.annotations.SerializedName

data class ResultLocation(
    @SerializedName("classify") val classify: String,
    @SerializedName("basic address") val basic_address: String,
    @SerializedName("detail address") val detail_address: String
)