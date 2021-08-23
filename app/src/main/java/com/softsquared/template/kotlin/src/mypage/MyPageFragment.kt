package com.softsquared.template.kotlin.src.mypage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentMyPageBinding
import com.softsquared.template.kotlin.src.location.LocationActivity
import com.softsquared.template.kotlin.src.mycoupon.MyCouponActivity
import com.softsquared.template.kotlin.src.mypage.model.UserInfoResponse

class MyPageFragment : BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind, R.layout.fragment_my_page), UserInfoView
    {
    private var mCount = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = activity!!.getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", Context.MODE_PRIVATE)
        var userId = text.getInt("userId", 0)
        var jwt = text.getString("X-ACCESS-TOKEN", null)
        Log.d("userId111", userId.toString()+" "+jwt)
        UserInfoService(this).tryGetNewDelivery(userId)

        // setting layout
        binding.layout9.setOnClickListener {
            var intent = Intent(context, SettingActivity::class.java)
            startActivity(intent)
        }

        // my_coupon
        binding.layout3.setOnClickListener {
            var intent = Intent(context, MyCouponActivity::class.java)
            startActivity(intent)
        }

        binding.layout1.setOnClickListener {
            var intent = Intent(context, LocationActivity::class.java)
            startActivity(intent)
        }
    }

        override fun onGetUserInfoSuccess(response: UserInfoResponse) {
            var username = response.result.get(0).userName
            var Phonenum = response.result.get(0).PhoneNumber.split("-")
            var phonenum = Phonenum.get(0)+"-xxxx-"+Phonenum.get(2)
            binding.userNameTxt.setText(username)
            binding.userPhoneTxt.setText(phonenum)
        }

        override fun onGetUserInfoFailure(message: String) {
            TODO("Not yet implemented")
        }
    }