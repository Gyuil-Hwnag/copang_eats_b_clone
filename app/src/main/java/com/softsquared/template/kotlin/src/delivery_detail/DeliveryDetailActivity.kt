package com.softsquared.template.kotlin.src.delivery_detail

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week6.TabAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityDeliveryDetailBinding
import com.softsquared.template.kotlin.src.delivery_detail.model.review

class DeliveryDetailActivity : BaseActivity<ActivityDeliveryDetailBinding>(ActivityDeliveryDetailBinding::inflate) {

    var reviewList = ArrayList<review>()
    lateinit var reviewAdapter: ReviewAdapter
    lateinit var reviewRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val toolbar = binding.toolbar
//        toolbar.title = binding.nameTxt.toString()
//        setSupportActionBar(toolbar)
//        if (supportActionBar != null) supportActionBar!!.setDisplayHomeAsUpEnabled(false) //툴바에 백키(<-) 보이게할거면 이거 사용


        for(i in 0..3){
            var item = review("https://s3.ap-northeast-2.amazonaws.com/img.castlejun-2.shop/CoupangEventImage/%EC%A7%9C%EC%9E%A5%EB%A9%B4.png",
                "생각보다 맛있었어요!!\n 그러나 다음번부터는 또 시킬지 모르겠어요", 3.0F)
            var item2 = review("https://s3.ap-northeast-2.amazonaws.com/img.castlejun-2.shop/CoupangEventImage/1%EC%9D%B8+%EA%B3%A0%EA%B8%B0+%EC%84%B8%ED%8A%B8.jpg",
                "너무 맛있었어요!!\n 서비스도 많이 주시고 다음번에 또 시켜먹을게요!!", 5.0F)
            var item3 = review("https://s3.ap-northeast-2.amazonaws.com/img.castlejun-2.shop/CoupangEventImage/1%EC%9D%B8+%EB%83%89%EB%A9%B4+%EC%84%B8%ED%8A%B8.png",
                "너무 별로였던것 같아요 기대를 하고 시켰는데 음... 많이 아닌것 같네요\n 리뷰를 안올리려다가 올려요!", 1.0F)
            reviewList.add(item)
            reviewList.add(item2)
            reviewList.add(item3)
        }
        reviewAdapter = ReviewAdapter(reviewList)
        reviewRecyclerView = binding.reviewRecyclerItem
        reviewRecyclerView.adapter = reviewAdapter
        reviewRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
            false)

        // 2. 초기화 지연시킨 viewPager2 객체를 여기서 초기화함
        var viewPager = binding.viewpager

        // 3. viewPager2 뷰 객체에 어댑터 적용하기
        viewPager.adapter = TabAdapter(this)

        TabLayoutMediator(binding.tabs, viewPager) { tab, position ->
            tab.text = "Title $position"
            when (position) {
                0 -> {
//                    tab.setIcon(R.drawable.ic_launcher_foreground)
                    tab.text = "해수욕장"
                }
                1 -> {
//                    tab.setIcon(R.drawable.ic_launcher_background)
                    tab.text = "Maps"
                }
            }
        }.attach()
    }
}