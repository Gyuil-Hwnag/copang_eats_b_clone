package com.softsquared.template.kotlin.src.location

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityLocationBinding
import com.softsquared.template.kotlin.src.location.model.LocationResponse
import com.softsquared.template.kotlin.src.location.model.location
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main_other.MainDeliveryAdapter
import com.softsquared.template.kotlin.src.main_other.model.other
import com.softsquared.template.kotlin.src.map.MapActivity


class LocationActivity : BaseActivity<ActivityLocationBinding>(ActivityLocationBinding::inflate), LocationView{

    var locationList = ArrayList<location>()
    lateinit var locationAdapter: LocationAdapter
    lateinit var locationRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", Context.MODE_PRIVATE)
        var userId = text.getInt("userId", 0)
        LocationService(this).tryGetLocation(userId)

        binding.mapChangeBtn.setOnClickListener {
            var intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        binding.closeBtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onGetLocationSuccess(response: LocationResponse) {
        for(i in 0..response.result.size-1){
            Log.d("slider", "")
            var locationImageUrl = response.result.get(i).classify
            var mainloc = response.result.get(i).basic_address
            var subloc = response.result.get(i).detail_address

            var item: location = location(locationImageUrl, mainloc, subloc)
            locationList.add(item)
        }
//        showCustomToast("성공")
        Log.d("success123", "success")

        locationAdapter = LocationAdapter(locationList)
        locationRecyclerView = binding.recyclerItem
        locationRecyclerView.adapter = locationAdapter
        locationRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
            false)
    }

    override fun onGetLocationFailure(message: String) {
//        showCustomToast("오류 : $message")
        Log.d("fail123", "$message")
    }
}