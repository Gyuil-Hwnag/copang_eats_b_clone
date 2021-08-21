package com.softsquared.template.kotlin.src.logout

import com.softsquared.template.kotlin.src.logout.model.PostLogoutRequest
import com.softsquared.template.kotlin.src.logout.model.LogoutResponse
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Path

interface logoutAPI {
    @POST("/app/{userId}/logout")
    fun postLogout(@Path("userId") userId: Int): Call<LogoutResponse>
}
