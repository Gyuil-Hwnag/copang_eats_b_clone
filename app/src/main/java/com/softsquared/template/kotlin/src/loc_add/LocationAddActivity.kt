package com.softsquared.template.kotlin.src.loc_add

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityLocationAddBinding
import com.softsquared.template.kotlin.databinding.ActivityLocationDetailBinding
import com.softsquared.template.kotlin.databinding.ActivityLoginBinding
import com.softsquared.template.kotlin.src.location.LocationActivity
import com.softsquared.template.kotlin.src.location.LocationAdapter
import com.softsquared.template.kotlin.src.location.LocationService
import com.softsquared.template.kotlin.src.location.LocationView
import com.softsquared.template.kotlin.src.location.model.LocationResponse
import com.softsquared.template.kotlin.src.location.model.location
import com.softsquared.template.kotlin.src.login.LoginService
import com.softsquared.template.kotlin.src.login.LoginView
import com.softsquared.template.kotlin.src.login.model.LoginResponse
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.map.MapActivity
import com.softsquared.template.kotlin.src.register.RegisterActivity

class LocationAddActivity : BaseActivity<ActivityLocationAddBinding>(ActivityLocationAddBinding::inflate),
    LocationView {

    var locationList = ArrayList<location>()
    lateinit var locationAdapter: LocationAdapter
    lateinit var locationRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", Context.MODE_PRIVATE)
        var userId = text.getInt("userId", 0)
        LocationService(this).tryGetLocation(userId)

        binding.addBtn.setOnClickListener {
            var intent = Intent(this, LocationActivity::class.java)
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
        showCustomToast("성공")
        Log.d("success123", "success")

        locationAdapter = LocationAdapter(locationList)
        locationRecyclerView = binding.recyclerItem
        locationRecyclerView.adapter = locationAdapter
        locationRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
            false)
    }

    override fun onGetLocationFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d("fail123", "$message")
    }
}