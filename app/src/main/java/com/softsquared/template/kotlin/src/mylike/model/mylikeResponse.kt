package com.softsquared.template.kotlin.src.mylike.model

import com.google.gson.annotations.SerializedName

data class mylikeResponse(
    // 베이스 리스폰스를 상속 받았으므로, 아래 내용은 포함이 되었습니다.
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: ArrayList<mylike>
)