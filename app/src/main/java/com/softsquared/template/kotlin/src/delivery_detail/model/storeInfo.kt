package com.softsquared.template.kotlin.src.delivery_detail.model

import com.google.gson.annotations.SerializedName

data class storeInfo(
    @SerializedName("storeId") val storeId: Int,
    @SerializedName("storeImageUrl") val storeImageUrl: List<String>,
    @SerializedName("storeName") val storeName: String,
    @SerializedName("cheetahDelivery") val cheetahDelivery: String,
    @SerializedName("averageStarRating") val averageStarRating: Float,
    @SerializedName("reviewCount") val reviewCount: Int,
    @SerializedName("averageDeliveryTime") val averageDeliveryTime: String,
    @SerializedName("deliveryTip") val deliveryTip: String,
    @SerializedName("limitOrderPrice") val limitOrderPrice: String
)