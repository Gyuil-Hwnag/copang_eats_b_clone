package com.softsquared.template.kotlin.src.main

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
import com.softsquared.template.kotlin.databinding.ActivityMainBinding
import com.softsquared.template.kotlin.src.event.EventView
import com.softsquared.template.kotlin.src.like.LikeActivity
import com.softsquared.template.kotlin.src.login.LoginActivity
import com.softsquared.template.kotlin.src.mylike.MyLikeActivity
import com.softsquared.template.kotlin.src.mypage.MyPageFragment
import com.softsquared.template.kotlin.src.order_history.HistoryFragment
import com.softsquared.template.kotlin.src.register.RegisterActivity
import com.softsquared.template.kotlin.src.search.SearchFragment


class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // shared preference
        var text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)
        var editor = text.edit()
        var login_status_jwt = text.getString("X-ACCESS-TOKEN", null)
        var login_status_userIdx = text.getInt("userIdx", -1)
//        showCustomToast("jwt : "+login_status_jwt)

        supportFragmentManager.beginTransaction().replace(R.id.main_frm, MainFragment()).commitAllowingStateLoss()

        binding.mainBtmNav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_main_btm_nav_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, MainFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_search -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, SearchFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_mark -> {
//                        var intent = Intent(this, LikeActivity::class.java)
//                        startActivity(intent)
                        var intent = Intent(this, MyLikeActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.menu_main_btm_nav_shop -> {
                        if(login_status_jwt == null){
                            val bottomSheet = BottomSheet()
                            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
                        }
                        else{
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.main_frm, HistoryFragment())
                                .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }
                    }
                    R.id.menu_main_btm_nav_my_page -> {
                        if(login_status_jwt == null){
                            val bottomSheet = BottomSheet()
                            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
                        }
                        else{
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.main_frm, MyPageFragment())
                                .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }
                    }
                }
                false
            })
    }
}