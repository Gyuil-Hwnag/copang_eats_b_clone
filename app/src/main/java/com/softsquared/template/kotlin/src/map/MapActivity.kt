package com.softsquared.template.kotlin.src.map

import android.R
import android.content.Intent
import android.graphics.PointF
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.NaverMap.OnMapClickListener
import com.naver.maps.map.util.FusedLocationSource
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityMapBinding
import com.softsquared.template.kotlin.src.location.LocationActivity
import com.softsquared.template.kotlin.src.location_detail.LocationDetailActivity


class MapActivity : BaseActivity<ActivityMapBinding>(ActivityMapBinding::inflate), OnMapReadyCallback {
    lateinit private var mapView: MapView
    lateinit private var locationSource: FusedLocationSource
    lateinit private var naverMap: NaverMap

    var latLng: LatLng = LatLng(25.1933895, 66.5949836)

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


        // 카메라 위치 이동후 경도, 위도
//        this.naverMap = naverMap
        binding.registerBtn.setOnClickListener {
            var cameraPosition = naverMap.cameraPosition
            showCustomToast("대상 지점 위도: " + cameraPosition.target.latitude + ", " +
                    "대상 지점 경도: " + cameraPosition.target.longitude + ", "
            )
            var intent = Intent(this, LocationDetailActivity::class.java)
            startActivity(intent)
//            Log.d("position!!","대상 지점 위도: " + cameraPosition.target.latitude + ", " +
//                    "대상 지점 경도: " + cameraPosition.target.longitude )
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
        uiSettings.isScaleBarEnabled = false // 거리
        uiSettings.isZoomControlEnabled = true // 줌
        uiSettings.isLocationButtonEnabled = false // 내가 있는곳

        var cameraPosition = naverMap.cameraPosition
        showCustomToast("대상 지점 위도: " + cameraPosition.target.latitude + ", " +
                "대상 지점 경도: " + cameraPosition.target.longitude + ", " +
                "줌 레벨: " + cameraPosition.zoom + ", " +
                "기울임 각도: " + cameraPosition.tilt + ", " +
                "베어링 각도: " + cameraPosition.bearing
        )
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }
}

