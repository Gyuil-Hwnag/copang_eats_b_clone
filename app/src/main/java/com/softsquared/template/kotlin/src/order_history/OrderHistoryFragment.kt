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
import com.softsquared.template.kotlin.databinding.FragmentOrderHistoryBinding
import com.softsquared.template.kotlin.src.location.LocationActivity
import com.softsquared.template.kotlin.src.location.MyLocationActivity
import com.softsquared.template.kotlin.src.mycoupon.MyCouponActivity
import com.softsquared.template.kotlin.src.mypage.model.UserInfoResponse

class OrderHistoryFragment : BaseFragment<FragmentOrderHistoryBinding>(FragmentOrderHistoryBinding::bind, R.layout.fragment_order_history) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = activity!!.getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", Context.MODE_PRIVATE)
        var userId = text.getInt("userId", 0)
        var jwt = text.getString("X-ACCESS-TOKEN", null)

//        var viewPager = binding.viewpager
//
//        // 3. viewPager2 뷰 객체에 어댑터 적용하기
//        viewPager.adapter = MyPagerAdapter(this)
//
//        TabLayoutMediator(binding.tabs, viewPager) { tab, position ->
//            tab.text = "Title $position"
//            when (position) {
//                0 -> {
////                    tab.setIcon(R.drawable.ic_launcher_foreground)
//                    tab.text = "과거 주문 내역"
//                }
//                1 -> {
////                    tab.setIcon(R.drawable.ic_launcher_background)
//                    tab.text = "준비중"
//                }
//            }
//        }.attach()
    }
}