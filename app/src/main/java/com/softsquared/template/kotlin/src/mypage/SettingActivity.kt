package com.softsquared.template.kotlin.src.mypage

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityMainBinding
import com.softsquared.template.kotlin.databinding.ActivitySettingBinding
import com.softsquared.template.kotlin.src.login.LoginActivity
import com.softsquared.template.kotlin.src.main.MainFragment
import com.softsquared.template.kotlin.src.search.SearchFragment

class SettingActivity : BaseActivity<ActivitySettingBinding>(ActivitySettingBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.logoutBtn.setOnClickListener {

        }
    }
}