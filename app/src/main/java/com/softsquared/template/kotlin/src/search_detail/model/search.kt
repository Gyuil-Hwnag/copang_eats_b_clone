package com.softsquared.template.kotlin.src.search_detail.model

import com.google.gson.annotations.SerializedName

data class search(
    @SerializedName("storeImageUrl") val storeImageUrl: List<String>,
    @SerializedName("storeName") val storeName: String,
    @SerializedName("cheetahDelivery") val cheetahDelivery: String,
    @SerializedName("averageDeliveryTime") val averageDeliveryTime: String,
    @SerializedName("averageStarRating") val averageStarRating: Float,
    @SerializedName("reviewCount") val reviewCount: Int,
    @SerializedName("distance") val distance: String,
    @SerializedName("deliveryTip") val deliveryTip: String,
    @SerializedName("coupon") val coupon: Int,
    @SerializedName("menuList") val menuList: String,
    @SerializedName("storeStatus") val storeStatus: String
)