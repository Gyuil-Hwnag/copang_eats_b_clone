package com.softsquared.template.kotlin.src.location_detail.model

import com.google.gson.annotations.SerializedName

data class LocationDetail(
    @SerializedName("address") val address: String,
    @SerializedName("detailAddress") val detailAddress: String,
    @SerializedName("infoAddress") val infoAddress: String,
    @SerializedName("latitude") val latitude: Float,
    @SerializedName("longitude") val longitude: Float,
    @SerializedName("category") val category: Int
)