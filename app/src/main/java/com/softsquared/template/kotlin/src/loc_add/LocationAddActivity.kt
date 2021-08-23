package com.softsquared.template.kotlin.src.loc_add

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityLocationAddBinding
import com.softsquared.template.kotlin.databinding.ActivityLocationDetailBinding
import com.softsquared.template.kotlin.databinding.ActivityLoginBinding
import com.softsquared.template.kotlin.src.location.LocationActivity
import com.softsquared.template.kotlin.src.login.LoginService
import com.softsquared.template.kotlin.src.login.LoginView
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.map.MapActivity
import com.softsquared.template.kotlin.src.register.RegisterActivity

class LocationAddActivity : BaseActivity<ActivityLocationAddBinding>(ActivityLocationAddBinding::inflate){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.addBtn.setOnClickListener {
            var intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
        }

    }
}