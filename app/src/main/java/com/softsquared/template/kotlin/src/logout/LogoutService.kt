package com.softsquared.template.kotlin.src.logout

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.logout.model.LogoutResponse
import com.softsquared.template.kotlin.src.logout.model.PostLogoutRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogoutService(val view: LogoutView) {
    fun tryPostLogout(postLogoutRequest: PostLogoutRequest){
        val logoutAPI = ApplicationClass.sRetrofit.create(logoutAPI::class.java)
        logoutAPI.postLogout(postLogoutRequest).enqueue(object :
            Callback<LogoutResponse> {
            override fun onResponse(call: Call<LogoutResponse>, response: Response<LogoutResponse>) {
                view.onPostLogoutSuccess(response.body() as LogoutResponse)
            }

            override fun onFailure(call: Call<LogoutResponse>, t: Throwable) {
                view.onPostLogoutFailure(t.message ?: "통신 오류")
            }
        })
    }
}