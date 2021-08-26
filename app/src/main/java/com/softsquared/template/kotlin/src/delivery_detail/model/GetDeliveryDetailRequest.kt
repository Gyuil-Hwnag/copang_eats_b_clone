package com.softsquared.template.kotlin.src.delivery_detail.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Path
import retrofit2.http.Query

data class GetDeliveryDetailRequest(
    @Path("userId") val userId: Int,
    @Query("storeId") val storeId: Int
)