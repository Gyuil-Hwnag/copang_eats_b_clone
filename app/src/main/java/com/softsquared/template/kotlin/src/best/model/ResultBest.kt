package com.softsquared.template.kotlin.src.best.model

import com.google.gson.annotations.SerializedName

data class ResultBest(
        @SerializedName("storeId") val storeId: Int,
        @SerializedName("storeImageUrl") val storeImageUrl: String,
        @SerializedName("storeName") val storeName: String,
//        @SerializedName("cheetahDelivery") val cheetahDelivery: Int,
        @SerializedName("averageStarRating") val averageStarRating: Float,
        @SerializedName("reviewCount") val reviewCount: Int,
        @SerializedName("distance") val distance: String,
        @SerializedName("deliveryTip") val deliveryTip: String,
        @SerializedName("storeStatus") val storeStatus: String
)