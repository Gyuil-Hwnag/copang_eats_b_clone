package com.softsquared.template.kotlin.src.event

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityEventAllBinding
import com.softsquared.template.kotlin.databinding.ActivityMainBinding
import com.softsquared.template.kotlin.src.coupon.CouponAdapter
import com.softsquared.template.kotlin.src.coupon.model.coupon
import com.softsquared.template.kotlin.src.event.EventView
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.event.model.event
import com.softsquared.template.kotlin.src.like.LikeActivity
import com.softsquared.template.kotlin.src.login.LoginActivity
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main_new.NewDeliveryAdapter
import com.softsquared.template.kotlin.src.main_new.model.new_delivery
import com.softsquared.template.kotlin.src.mypage.MyPageFragment
import com.softsquared.template.kotlin.src.register.RegisterActivity
import com.softsquared.template.kotlin.src.search.SearchFragment


class EventAllActivity : BaseActivity<ActivityEventAllBinding>(ActivityEventAllBinding::inflate), EventView {

    var eventList = ArrayList<event>()
    lateinit var eventallAdapter: EventAllAdapter
    lateinit var eventallRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // shared preference
        var text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)
        var userId = text.getInt("userIdx", -1)

        EventService(this).tryPostEvent()
        binding.closeBtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPostEventSuccess(response: EventResponse) {
        for(i in 0..response.result.size-1){
            Log.d("slider", "")
            var evnet_Img = response.result.get(i).eventImageUrl
            var event: event = event(evnet_Img,0)
            eventList.add(event)
        }
//        showCustomToast("성공")
        Log.d("success123", "success")

        eventallAdapter = EventAllAdapter(eventList)
        eventallRecyclerView = binding.recyclerItem
        eventallRecyclerView.adapter = eventallAdapter
        eventallRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
            false)
    }

    override fun onPostEventFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d("fail123", "fail")
    }
}