package com.softsquared.template.kotlin.src.add_cart

import com.google.gson.annotations.SerializedName

data class AddCartRequest(
    @SerializedName("storeId") val storeId: Int,
    @SerializedName("menuCount") val menuCount: Int,
    @SerializedName("menuId") val menuId: Int,
    @SerializedName("orderArray") val orderArray: ArrayList<orderArray>
)