package com.softsquared.template.kotlin.src.add_cart

import com.google.gson.annotations.SerializedName

data class orderArray(
    @SerializedName("menuCategoryId") val menuCategoryId: String,
    @SerializedName("menuDetailId") val menuDetailId: String
)