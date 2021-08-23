package com.softsquared.template.kotlin.src.location_detail

import com.softsquared.template.kotlin.src.location_detail.model.LocationDetailResponse
import com.softsquared.template.kotlin.src.location_detail.model.PostLocationDetailRequest
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.register.model.PostRegisterRequest
import com.softsquared.template.kotlin.src.register.model.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface LocationDetailAPI {
    @POST("/app/users/{userId}/add-address")
    fun postLocationDetail(@Path("userId") userId: Int,
                     @Body params: PostLocationDetailRequest): Call<LocationDetailResponse>
}