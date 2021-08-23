package com.softsquared.template.kotlin.src.main_new.model

import com.google.gson.annotations.SerializedName

data class new_delivery(
    @SerializedName("storeImageUrl") val storeImageUrl: String,
    @SerializedName("storeName") val storeName: String,
//    @SerializedName("cheetahDelivery") val cheetahDelivery: Int,
    @SerializedName("averageStarRating") val averageStarRating: Float,
    @SerializedName("reviewCount") val reviewCount: Int,
    @SerializedName("distance") val distance: String,
    @SerializedName("deliveryTip") val deliveryTip: String,
    @SerializedName("storeStatus") val storeStatus: String
// @SerializedName("coupon_logo") val coupon_logo: String
)