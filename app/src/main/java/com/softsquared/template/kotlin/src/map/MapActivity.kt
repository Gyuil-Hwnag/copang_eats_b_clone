package com.softsquared.template.kotlin.src.map

import android.content.Intent
import android.os.Bundle
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityMapBinding
import com.softsquared.template.kotlin.src.location.LocationActivity


class MapActivity : BaseActivity<ActivityMapBinding>(ActivityMapBinding::inflate) {

    lateinit var mapView: com.naver.maps.map.MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapView = binding.mapView
//        mapView = view.findViewById(R.id.map_view)
        mapView.onCreate(savedInstanceState)

//        val marker = Marker()
//        marker.position = LatLng(37.5670135, 126.9783740)
//        marker.map = mapView

        binding.preBtn.setOnClickListener {
            var intent = Intent(this, LocationActivity::class.java)
            startActivity(intent)
        }
    }

//    private fun setMark(marker: Marker, lat: Double, lng: Double, resourceID: Int) {
//        //원근감 표시
//        marker.isIconPerspectiveEnabled = true
//        //아이콘 지정
//        marker.icon = OverlayImage.fromResource(resourceID)
//        //마커의 투명도
//        marker.alpha = 0.8f
//        //마커 위치
//        marker.position = LatLng(lat, lng)
//        //마커 우선순위
//        marker.zIndex = 10
//        //마커 표시
//        marker.map = naverMap
//    }
}