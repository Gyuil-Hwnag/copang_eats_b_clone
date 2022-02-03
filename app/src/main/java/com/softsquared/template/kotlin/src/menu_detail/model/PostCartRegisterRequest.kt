package com.softsquared.template.kotlin.src.menu_detail.model

import com.google.gson.annotations.SerializedName

data class PostCartRegisterRequest(
    @SerializedName("userId") val userId: Int,
    @SerializedName("storeId") val storeId: String,
    @SerializedName("menuCount") val menuCount: String,
    @SerializedName("menuId") val menuId: String,
    @SerializedName("orderArray") val orderArray: ArrayList<cartMenu>
)