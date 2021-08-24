package com.softsquared.template.kotlin.src.delivery_detail

import android.R.id
import android.R.id.tabs
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.view.menu.MenuAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityDeliveryDetailBinding
import com.softsquared.template.kotlin.src.delivery_detail.model.menu
import com.softsquared.template.kotlin.src.delivery_detail.model.review


class DeliveryDetailActivity : BaseActivity<ActivityDeliveryDetailBinding>(ActivityDeliveryDetailBinding::inflate) {

    var reviewList = ArrayList<review>()
    lateinit var reviewAdapter: ReviewAdapter
    lateinit var reviewRecyclerView: RecyclerView

    lateinit var fram1: FrameLayout
    lateinit var fram2: FrameLayout
    lateinit var fram3: FrameLayout
    lateinit var fram4: FrameLayout
    lateinit var fram5: FrameLayout

    var menuList1 = ArrayList<menu>()
    lateinit var menuAdapter1: DeliveryMenuAdapter
    lateinit var RecyclerView1: RecyclerView

    var menuList2 = ArrayList<menu>()
    lateinit var menuAdapter2: DeliveryMenuAdapter
    lateinit var RecyclerView2: RecyclerView

    var menuList3 = ArrayList<menu>()
    lateinit var menuAdapter3: DeliveryMenuAdapter
    lateinit var RecyclerView3: RecyclerView

    var menuList4 = ArrayList<menu>()
    lateinit var menuAdapter4: DeliveryMenuAdapter
    lateinit var RecyclerView4: RecyclerView

    var menuList5 = ArrayList<menu>()
    lateinit var menuAdapter5: DeliveryMenuAdapter
    lateinit var RecyclerView5: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        var fram1 = binding.fram1
        var fram2 = binding.fram2
        var fram3 = binding.fram3
        var fram4 = binding.fram4
        var fram5 = binding.fram5

//        @SerializedName("menuName") val menuName: String,
//        @SerializedName("menuPrice") val menuPrice: Int,
//        @SerializedName("menuDescription") val menuDescription: String,
//        @SerializedName("menuImageUrl") val menuImageUrl: String

        for(i in 0..3){
            var item = menu("짜장", 15000, "기본 자장면입니다",
                "https://s3.ap-northeast-2.amazonaws.com/img.castlejun-2.shop/CoupangEventImage/%EC%A7%9C%EC%9E%A5%EB%A9%B4.png")
            var item2 = menu("짜장", 15000, "기본 자장면입니다",
                "https://s3.ap-northeast-2.amazonaws.com/img.castlejun-2.shop/CoupangEventImage/1%EC%9D%B8+%EA%B3%A0%EA%B8%B0+%EC%84%B8%ED%8A%B8.jpg")
            var item3 = menu("짜장", 15000, "기본 자장면입니다",
                "https://s3.ap-northeast-2.amazonaws.com/img.castlejun-2.shop/CoupangEventImage/1%EC%9D%B8+%EB%83%89%EB%A9%B4+%EC%84%B8%ED%8A%B8.png")
            menuList1.add(item)
            menuList1.add(item2)
            menuList1.add(item3)

            menuList2.add(item)
            menuList2.add(item2)
            menuList2.add(item3)

            menuList3.add(item)
            menuList3.add(item2)
            menuList3.add(item3)

            menuList4.add(item)
            menuList4.add(item2)
            menuList4.add(item3)

            menuList5.add(item)
            menuList5.add(item2)
            menuList5.add(item3)
        }
        menuAdapter1 = DeliveryMenuAdapter(menuList1)
        menuAdapter2 = DeliveryMenuAdapter(menuList2)
        menuAdapter3 = DeliveryMenuAdapter(menuList3)
        menuAdapter4 = DeliveryMenuAdapter(menuList4)
        menuAdapter5 = DeliveryMenuAdapter(menuList5)

        RecyclerView1 = binding.recyclerItem1
        RecyclerView2 = binding.recyclerItem2
        RecyclerView3 = binding.recyclerItem3
        RecyclerView4 = binding.recyclerItem4
        RecyclerView5 = binding.recyclerItem5

        RecyclerView1.adapter = menuAdapter1
        RecyclerView2.adapter = menuAdapter2
        RecyclerView3.adapter = menuAdapter3
        RecyclerView4.adapter = menuAdapter4
        RecyclerView5.adapter = menuAdapter5

        RecyclerView1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
            false)
        RecyclerView2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
            false)
        RecyclerView3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
            false)
        RecyclerView4.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
            false)
        RecyclerView5.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
            false)

        binding.tabs.addTab(binding.tabs.newTab().setText("tab1"))
        binding.tabs.addTab(binding.tabs.newTab().setText("tab2"))
        binding.tabs.addTab(binding.tabs.newTab().setText("tab3"))
        binding.tabs.addTab(binding.tabs.newTab().setText("tab4"))
        binding.tabs.addTab(binding.tabs.newTab().setText("tab5"))

        binding.tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab!!.position) {
                    0 -> binding.scrollView.scrollTo(0, fram1.top)
                    1 -> binding.scrollView.scrollTo(0, fram2.top)
                    2 -> binding.scrollView.scrollTo(0, fram3.top)
                    3 -> binding.scrollView.scrollTo(0, fram4.top)
                    4 -> binding.scrollView.scrollTo(0, fram5.top)
                }
            }
        })

    }
}