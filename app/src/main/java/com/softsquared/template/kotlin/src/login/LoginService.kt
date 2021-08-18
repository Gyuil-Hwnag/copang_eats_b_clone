package com.softsquared.template.kotlin.src.login

import androidx.appcompat.app.AppCompatActivity
import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.register.model.PostRegisterRequest
import com.softsquared.template.kotlin.src.register.model.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val view: LoginView) {
    fun tryPostLogin(postLoginRequest: PostLoginRequest){
        val LoginAPI = ApplicationClass.sRetrofit.create(LoginAPI::class.java)
        LoginAPI.postRegister(postLoginRequest).enqueue(object :
            Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                view.onPostLoginSuccess(response.body() as LoginResponse)
//                var text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP",
//                    AppCompatActivity.MODE_PRIVATE
//                )
//                var editor = text.edit()
//                editor.putString("X-ACCESS-TOKEN", response.body()!!.jwt)
//                editor.putInt("userIdx", response.body()!!.userIdx)
//                showCustomToast("jwt : "+response.jwt+ " "+ "userIdx : "+response.userIdx.toString())
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                view.onPostLoginFailure(t.message ?: "통신 오류")
            }
        })
    }
}