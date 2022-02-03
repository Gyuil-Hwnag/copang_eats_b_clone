package com.softsquared.template.kotlin.src.map.model

import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.config.BaseResponse

data class RegisterLocationResponse(
    // 베이스 리스폰스를 상속 받았으므로, 아래 내용은 포함이 되었습니다.
     @SerializedName("isSuccess") val isSuccess: String,
     @SerializedName("code") val code: String,
     @SerializedName("message") val message: String
)