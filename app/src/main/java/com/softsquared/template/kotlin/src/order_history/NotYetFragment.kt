package com.softsquared.template.kotlin.src.order_history

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.week6.MyPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentMyPageBinding
import com.softsquared.template.kotlin.databinding.FragmentNotYetBinding
import com.softsquared.template.kotlin.databinding.FragmentOrderHistoryBinding
import com.softsquared.template.kotlin.src.location.LocationActivity
import com.softsquared.template.kotlin.src.location.MyLocationActivity
import com.softsquared.template.kotlin.src.mycoupon.MyCouponActivity
import com.softsquared.template.kotlin.src.mypage.model.UserInfoResponse

class NotYetFragment : BaseFragment<FragmentNotYetBinding>(FragmentNotYetBinding::bind, R.layout.fragment_not_yet) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}