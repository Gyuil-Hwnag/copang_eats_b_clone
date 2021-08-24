package com.softsquared.template.kotlin.src.location

import com.softsquared.template.kotlin.src.location.model.LocationResponse
import com.softsquared.template.kotlin.src.main_loc.model.MainLocResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LocationAPI {
    @GET("app/users/{userId}/address")
    fun getLocation(@Path("userId") userId: Int): Call<LocationResponse>
}
