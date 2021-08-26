package com.softsquared.template.kotlin.src.order_history.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class history(
    @SerializedName("orderId") val orderId: Int,
    @SerializedName("storeImage") val storeImage: String,
    @SerializedName("storeName") val storeName: String,
    @SerializedName("orderDate") val orderDate: String,
    @SerializedName("orderState") val orderState: String,
    @SerializedName("starRating") val starRating: Float,
    @SerializedName("menuList") val menuList: String?,
    @SerializedName("sumCost") val sumCost: Int
)