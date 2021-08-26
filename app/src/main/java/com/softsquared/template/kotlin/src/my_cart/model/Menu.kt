package com.softsquared.template.kotlin.src.my_cart.model

import com.google.gson.annotations.SerializedName

data class Menu(
    @SerializedName("menuCount") val menuCount: Int,
    @SerializedName("menuName") val menuName: String,
    @SerializedName("menuPrice") val menuPrice: Int,
    @SerializedName("storeId") val storeId: Int
)