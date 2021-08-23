package com.softsquared.template.kotlin.src.main_other.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Path

data class GetotherRequest(
    @Path("userId") val userId: Int
)