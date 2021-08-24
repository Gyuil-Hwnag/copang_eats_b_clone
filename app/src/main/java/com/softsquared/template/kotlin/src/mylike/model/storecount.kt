package com.softsquared.template.kotlin.src.mylike.model

import com.google.gson.annotations.SerializedName

data class storecount(
    @SerializedName("count(bookmark)") val count: String
)