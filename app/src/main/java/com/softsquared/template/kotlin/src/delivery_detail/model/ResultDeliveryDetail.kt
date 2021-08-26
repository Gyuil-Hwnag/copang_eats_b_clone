package com.softsquared.template.kotlin.src.delivery_detail.model

import com.google.gson.annotations.SerializedName

data class ResultDeliveryDetail(
//        @SerializedName("Store Top Info") val storeInfo: ArrayList<>,
//        @SerializedName("Preview Review") val preview_review: ArrayList<>,
        @SerializedName("storeName") val storeName: String,
//        @SerializedName("cheetahDelivery") val cheetahDelivery: Int,
        @SerializedName("averageStarRating") val averageStarRating: Float,
        @SerializedName("reviewCount") val reviewCount: Int,
        @SerializedName("distance") val distance: String,
        @SerializedName("deliveryTip") val deliveryTip: String,
        @SerializedName("storeStatus") val storeStatus: String
)