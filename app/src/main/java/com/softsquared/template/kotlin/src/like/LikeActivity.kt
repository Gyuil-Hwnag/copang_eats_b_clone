package com.softsquared.template.kotlin.src.like

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityLikeBinding
import com.softsquared.template.kotlin.databinding.ActivityMainBinding
import com.softsquared.template.kotlin.src.event.EventView
import com.softsquared.template.kotlin.src.login.LoginActivity
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.mypage.MyPageFragment
import com.softsquared.template.kotlin.src.register.RegisterActivity
import com.softsquared.template.kotlin.src.search.SearchFragment


class LikeActivity : BaseActivity<ActivityLikeBinding>(ActivityLikeBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.mainBtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}