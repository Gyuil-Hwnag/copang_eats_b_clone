package com.softsquared.template.kotlin.src.menu_detail.model

import com.google.gson.annotations.SerializedName

data class PostCartRegisterRequest(
    @SerializedName("storeId") val storeId: Int,
    @SerializedName("menuCount") val menuCount: Int,
    @SerializedName("menuId") val menuId: Int,
    @SerializedName("orderArray") val orderArray: ArrayList<cartMenu>
)