package com.softsquared.template.kotlin.src.location_detail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.softsquared.template.kotlin.config.BaseActivity
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

class LocationDetailActivity : BaseActivity<ActivityLocationDetailBinding>(ActivityLocationDetailBinding::inflate),
    LocationDetailView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var loc = intent.getStringExtra("location")
        var latitude = intent.getStringExtra("latitude")
        var longitude = intent.getStringExtra("longitude")
        showCustomToast("latitude : "+latitude+" longitude : "+longitude)
        binding.txtLocMain.setText(loc)
        binding.txtSubMain.setText(loc)
        var text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)
        var userId = text.getInt("userId", 0)

        binding.registerBtn.setOnClickListener {
            if(binding.detail.text.toString() == "" || binding.subDetail.text.toString() == ""){
                val bottomSheet = LocBottomSheet()
                bottomSheet.show(supportFragmentManager, bottomSheet.tag)
                var editor = text.edit()
                editor.putString("location", binding.txtLocMain.text.toString())
                editor.commit()
            }
            else{
                val address = binding.txtLocMain.text.toString()
                val detailAddress = binding.detail.text.toString()
                val infoAddress = binding.subDetail.text.toString()
                val latitudeLoc = latitude!!.toFloat()
                val longitudeLoc = longitude!!.toFloat()
                val category = 0

                val postRequest = PostLocationDetailRequest(address = address, detailAddress = detailAddress, infoAddress = infoAddress,
                    latitude = latitudeLoc, longitude = longitudeLoc, category = category)
                showLoadingDialog(this)
                LocationDetailService(this).tryPostLocationDetail(userId, postRequest)
            }
        }

        binding.mapReturn.setOnClickListener {
            var intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPostLocationDetailSuccess(response: LocationDetailResponse) {
        dismissLoadingDialog()
        response.message?.let { showCustomToast(it) }

        var intent = Intent(this, LocationAddActivity::class.java)
        startActivity(intent)
        Log.d("success111", "success")

    }

    override fun onPostLocationDetailFailure(message: String) {
        TODO("Not yet implemented")
    }
}