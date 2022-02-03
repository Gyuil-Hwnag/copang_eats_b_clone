package com.softsquared.template.kotlin.src.location_detail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.databinding.ActivityLocationDetailBinding
import com.softsquared.template.kotlin.src.loc_add.LocationAddActivity
import com.softsquared.template.kotlin.src.location.LocationActivity
import com.softsquared.template.kotlin.src.location_detail.model.LocationDetailResponse
import com.softsquared.template.kotlin.src.location_detail.model.PostLocationDetailRequest
import com.softsquared.template.kotlin.src.login.LoginService
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.main.BottomSheet
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.map.MapActivity
import com.softsquared.template.kotlin.src.map.RegisterLocationService
import com.softsquared.template.kotlin.src.map.RegisterLocationView
import com.softsquared.template.kotlin.src.map.model.RegisterLocationRequest

class LocationDetailActivity : BaseActivity<ActivityLocationDetailBinding>(ActivityLocationDetailBinding::inflate),
    LocationDetailView, RegisterLocationView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var loc = intent.getStringExtra("location")
        var latitude = intent.getStringExtra("latitude")
        var longitude = intent.getStringExtra("longitude")
//        showCustomToast("latitude : "+latitude+" longitude : "+longitude)
        binding.txtLocMain.setText(loc)
        binding.txtSubMain.setText(loc)
        var text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)
        var userId = text.getInt("userId", 0)
        var category = 2

        binding.home.setOnClickListener {
            category = 0
        }
        binding.office.setOnClickListener {
            category = 1
        }

        binding.registerBtn.setOnClickListener {
            if(binding.detail.text.toString() == "" || binding.subDetail.text.toString() == ""){
                val bottomSheet = LocBottomSheet()
                bottomSheet.show(supportFragmentManager, bottomSheet.tag)
                var editor = text.edit()
                editor.putString("detail_location", binding.txtLocMain.text.toString())
                editor.putString("main_location", binding.txtLocMain.text.toString())
                editor.putString("info_location", " ")
                editor.putString("latitude", latitude)
                editor.putString("longitude", longitude)
                editor.putString("location", binding.txtLocMain.text.toString())
                editor.putInt("category", category)
                editor.commit()
            }
            else{
                val address = binding.txtLocMain.text.toString()
                val detailAddress = binding.detail.text.toString()
                val infoAddress = binding.subDetail.text.toString()
                val latitudeLoc = latitude!!.toFloat()
                val longitudeLoc = longitude!!.toFloat()

                val postRequest = RegisterLocationRequest(userId = userId, address = address!!, detailAddress = detailAddress!!, infoAddress = infoAddress!!,
                    latitude = latitudeLoc, longitude = longitudeLoc, category = category)
                RegisterLocationService(this).tryPostLogin(postRequest)
            }
        }

        binding.mapReturn.setOnClickListener {
            var intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPostLocationDetailSuccess(response: LocationDetailResponse) {


    }

    override fun onPostLocationDetailFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun onPostRegisterLocationSuccess(response: BaseResponse) {
        dismissLoadingDialog()
        response.message?.let { showCustomToast(it) }

        var intent = Intent(this, LocationAddActivity::class.java)
        startActivity(intent)
        Log.d("add_location_success", "success")
    }

    override fun onPostRegisterLocationFailure(message: String) {
        Log.d("fail123", " $message")
    }
}