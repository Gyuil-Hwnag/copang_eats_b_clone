package com.softsquared.template.kotlin.src.mypage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityMainBinding
import com.softsquared.template.kotlin.databinding.ActivitySettingBinding
import com.softsquared.template.kotlin.src.login.LoginActivity
import com.softsquared.template.kotlin.src.logout.LogoutService
import com.softsquared.template.kotlin.src.logout.LogoutView
import com.softsquared.template.kotlin.src.logout.model.LogoutResponse
import com.softsquared.template.kotlin.src.logout.model.PostLogoutRequest
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main.MainFragment
import com.softsquared.template.kotlin.src.register.RegisterService
import com.softsquared.template.kotlin.src.register.model.PostRegisterRequest
import com.softsquared.template.kotlin.src.register.model.SignUpResponse
import com.softsquared.template.kotlin.src.search.SearchFragment
import com.softsquared.template.kotlin.src.splash.SplashActivity

class SettingActivity : BaseActivity<ActivitySettingBinding>(ActivitySettingBinding::inflate), LogoutView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.logoutBtn.setOnClickListener {
            var text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)
            var editor = text.edit()

            showLoadingDialog(this)
            var userId = text.getInt("userId", 0)
            Log.d("userId", userId.toString())
            LogoutService(this).tryPostLogout(userId)
        }
    }

    override fun onPostLogoutSuccess(response: LogoutResponse) {
        dismissLoadingDialog()
        binding.logoutBtn.text = response.message
        response.message?.let { showCustomToast(it) }

        var text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)
        var editor = text.edit()
        editor.putString("X-ACCESS-TOKEN", null)
        editor.putInt("userId", 0)
        editor.commit()
        var intent = Intent(this, SplashActivity::class.java)
        startActivity(intent)
        Log.d("success!!!", "success")
    }

    override fun onPostLogoutFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
        Log.d("fail123", "fail")
//        var intent = Intent(this, SplashActivity::class.java)
//        startActivity(intent)
    }
}