package com.softsquared.template.kotlin.src.add_cart

import com.google.gson.annotations.SerializedName

data class AddCartRequest(
    @SerializedName("storeId") val storeId: String,
    @SerializedName("menuCount") val menuCount: String,
    @SerializedName("menuId") val menuId: String,
    @SerializedName("orderArray") val orderArray: orderArray
)