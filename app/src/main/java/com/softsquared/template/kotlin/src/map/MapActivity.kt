package com.softsquared.template.kotlin.src.map

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityMainBinding
import com.softsquared.template.kotlin.databinding.ActivityMapBinding
import com.softsquared.template.kotlin.src.location.LocationActivity
import com.softsquared.template.kotlin.src.main.MainFragment
import com.softsquared.template.kotlin.src.mypage.MyPageFragment

class MapActivity : BaseActivity<ActivityMapBinding>(ActivityMapBinding::inflate) {

    lateinit var mapView: com.naver.maps.map.MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapView = binding.mapView
//        mapView = view.findViewById(R.id.map_view)
        mapView.onCreate(savedInstanceState)

        binding.preBtn.setOnClickListener {
            var intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
        }
    }
}