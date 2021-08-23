package com.softsquared.template.kotlin.src.main_loc.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Path

data class GetMainLocRequest(
    @Path("userId") val userId: Int
)