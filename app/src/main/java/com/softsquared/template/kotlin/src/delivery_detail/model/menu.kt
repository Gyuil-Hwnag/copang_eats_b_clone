package com.softsquared.template.kotlin.src.delivery_detail.model

import com.google.gson.annotations.SerializedName

data class menu(
    @SerializedName("menuIdx") val menuIdx: Int,
    @SerializedName("menuName") val menuName: String,
    @SerializedName("menuPrice") val menuPrice: Int,
    @SerializedName("menuDescription") val menuDescription: String,
    @SerializedName("menuImageUrl") val menuImageUrl: String
)