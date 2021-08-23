package com.softsquared.template.kotlin.src.main_other.model

import com.google.gson.annotations.SerializedName

data class other(
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
// @SerializedName("coupon_logo") val coupon_logo: String
)