package com.softsquared.template.kotlin.src.location_detail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.softsquared.template.kotlin.config.BaseActivity
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

class LocationDetailActivity : BaseActivity<ActivityLocationDetailBinding>(ActivityLocationDetailBinding::inflate){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.registerBtn.setOnClickListener {
            var intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
        }

        binding.mapReturn.setOnClickListener {
            var intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

    }
}