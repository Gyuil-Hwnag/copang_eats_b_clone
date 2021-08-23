package com.softsquared.template.kotlin.src.mypage

import com.softsquared.template.kotlin.src.main_loc.model.MainLocResponse
import com.softsquared.template.kotlin.src.mypage.model.UserInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserInfoAPI {
    @GET("app/users/{userId}/name-number")
    fun getUserInfo(@Path("userId") userId: Int): Call<UserInfoResponse>
}
