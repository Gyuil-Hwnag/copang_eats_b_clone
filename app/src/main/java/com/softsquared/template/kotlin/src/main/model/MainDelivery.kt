package com.softsquared.template.kotlin.src.main.model

import com.google.gson.annotations.SerializedName

data class MainDelivery(
    @SerializedName("storeImageUrl") val storeImageUrl: String,
    @SerializedName("storeName") val storeName: String,
    @SerializedName("cheetahDelivery") val cheetahDelivery: Int,
    @SerializedName("averageStarRating") val averageStarRating: Float,
    @SerializedName("reviewCount") val reviewCount: Int,
    @SerializedName("distance") val distance: Float,
    @SerializedName("deliveryTip") val deliveryTip: Int,
    @SerializedName("storeStatus") val storeStatus: String
    // @SerializedName("coupon_logo") val coupon_logo: String
    )