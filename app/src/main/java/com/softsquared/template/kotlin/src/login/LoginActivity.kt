package com.softsquared.template.kotlin.src.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityLoginBinding
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.register.RegisterActivity

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate), LoginView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.loginBtn.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val postRequest = PostLoginRequest(email = email, password = password)
            showLoadingDialog(this)
            LoginService(this).tryPostLogin(postRequest)
        }

        binding.register.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPostLoginSuccess(response: LoginResponse) {
        dismissLoadingDialog()
        binding.loginBtn.text = response.message
        response.message?.let { showCustomToast(it) }

        // shared preference
        var text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)
        var editor = text.edit()
        editor.putString("X-ACCESS-TOKEN", response.result.jwt)
        editor.putInt("userId", response.result.userId)
        editor.commit()

        Log.d("success111","userId : "+response.result.userId.toString())

        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        Log.d("success111", "success")
    }

    override fun onPostLoginFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
        Log.d("fail123", "fail")
    }
}