package com.softsquared.template.kotlin.src.delivery_detail.model

import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.config.BaseResponse
import org.json.JSONObject

data class DeliveryDetailResponse(
    // 베이스 리스폰스를 상속 받았으므로, 아래 내용은 포함이 되었습니다.
     @SerializedName("isSuccess") val isSuccess: Boolean,
     @SerializedName("code") val code: Int,
     @SerializedName("message") val message: String,
     @SerializedName("result") val result: ArrayList<JSONObject>
)