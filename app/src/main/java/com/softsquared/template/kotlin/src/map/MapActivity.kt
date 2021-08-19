package com.softsquared.template.kotlin.src.map

import android.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import com.naver.maps.map.util.FusedLocationSource
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityMapBinding
import com.softsquared.template.kotlin.src.location.LocationActivity


class MapActivity : BaseActivity<ActivityMapBinding>(ActivityMapBinding::inflate), OnMapReadyCallback {
    lateinit private var mapView: MapView
    lateinit private var locationSource: FusedLocationSource
    lateinit private var naverMap: NaverMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapView = binding.mapView
        mapView!!.onCreate(savedInstanceState)
        mapView!!.getMapAsync(this)
        locationSource = FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)

        binding.preBtn.setOnClickListener {
            var intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
        }
    }

    //위치정보 권한 설정
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        if (locationSource!!.onRequestPermissionsResult(
                requestCode, permissions, grantResults
            )
        ) {
            return
        }
        super.onRequestPermissionsResult(
            requestCode, permissions, grantResults
        )
    }

    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap
        // NaverMap 객체 받아서 NaverMap 객체에 위치 소스 지정
        naverMap.locationSource = locationSource
        naverMap.locationTrackingMode = LocationTrackingMode.Follow

        val uiSettings = naverMap.uiSettings
        uiSettings.isCompassEnabled = false // 나침반
        uiSettings.isScaleBarEnabled = true // 거리
        uiSettings.isZoomControlEnabled = false // 줌
        uiSettings.isLocationButtonEnabled = true // 내가 있는곳

    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }
}

