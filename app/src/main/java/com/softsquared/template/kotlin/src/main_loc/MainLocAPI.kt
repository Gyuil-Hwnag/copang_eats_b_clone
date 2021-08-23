package com.softsquared.template.kotlin.src.main_loc

import com.softsquared.template.kotlin.src.main_loc.model.MainLocResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MainLocAPI {
    @GET("app/users/{userId}/default-address")
    fun getNewDelivery(@Path("userId") userId: Int): Call<MainLocResponse>
}
