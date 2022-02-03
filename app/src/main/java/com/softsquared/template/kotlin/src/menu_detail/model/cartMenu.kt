package com.softsquared.template.kotlin.src.menu_detail.model

import com.google.gson.annotations.SerializedName

data class cartMenu(
    @SerializedName("menuCategoryId") val menuCategoryId: String,
    @SerializedName("menuDetailId") val menuCategory: String
)