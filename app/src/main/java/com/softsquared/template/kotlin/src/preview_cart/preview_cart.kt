package com.softsquared.template.kotlin.src.preview_cart

import com.google.gson.annotations.SerializedName
import java.util.*

data class preview_cart(
    @SerializedName("CartCount") val CartCount: Int,
    @SerializedName("SumPrice") val SumPrice: Int
)