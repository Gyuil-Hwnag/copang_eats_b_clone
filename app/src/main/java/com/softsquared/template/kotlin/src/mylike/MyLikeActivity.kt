package com.softsquared.template.kotlin.src.mylike

import android.content.Context
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
import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityLikeBinding
import com.softsquared.template.kotlin.databinding.ActivityMainBinding
import com.softsquared.template.kotlin.databinding.ActivityMyLikeBinding
import com.softsquared.template.kotlin.databinding.ActivityMyLocationBinding
import com.softsquared.template.kotlin.src.event.EventView
import com.softsquared.template.kotlin.src.like.LikeActivity
import com.softsquared.template.kotlin.src.login.LoginActivity
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main_other.MainDeliveryAdapter
import com.softsquared.template.kotlin.src.main_other.model.other
import com.softsquared.template.kotlin.src.mylike.model.mylike
import com.softsquared.template.kotlin.src.mylike.model.mylikeResponse
import com.softsquared.template.kotlin.src.mypage.MyPageFragment
import com.softsquared.template.kotlin.src.register.RegisterActivity
import com.softsquared.template.kotlin.src.search.SearchFragment


class MyLikeActivity : BaseActivity<ActivityMyLikeBinding>(ActivityMyLikeBinding::inflate), mylikeView {

    var mylikeList = ArrayList<mylike>()
    lateinit var mylikeAdapter: mylikeAdapter
    lateinit var mylikeRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)
        var userId = text.getInt("userId", 0)

        mylikeService(this).tryGetmylike(userId, "recent-plus")
    }

    override fun onGetmylikeSuccess(response: mylikeResponse) {
        if(response.result.size == 0){
            var intent = Intent(this, LikeActivity::class.java)
            startActivity(intent)
        }
        else{
            var result = response.result
            binding.countTxt.setText("총 "+response.result.size+"개")

            for(i in 0..result.size-1){
                Log.d("slider", "")
                var storeId = result.get(i).storeId
                var storeImageUrl1 = response.result.get(i).storeImageUrl
                val Imgarr = storeImageUrl1.split(",")
                var storeImageUrl = Imgarr.get(0)
                var storeName = result.get(i).storeName
                var cheetahDelivery = result.get(i).cheetahDelivery
                Log.d("nul123", "success")
                if(cheetahDelivery == null){
                    Log.d("chita:null", "success")
                    cheetahDelivery = "NULL"
                }
                var averageDeliveryTime = result.get(i).averageDeliveryTime
                var averageStarRating = result.get(i).averageStarRating
                var reviewCount = result.get(i).reviewCount
                var distance = result.get(i).distance
                var deliveryTip = result.get(i).deliveryTip
                var storeStatus = result.get(i).storeStatus

                var item: mylike = mylike(storeId, storeImageUrl, storeName, cheetahDelivery, averageDeliveryTime, averageStarRating,
                    reviewCount, distance, deliveryTip, storeStatus)
                mylikeList.add(item)
            }
            showCustomToast("성공")
            Log.d("likeSuccess", "success")

            mylikeAdapter = mylikeAdapter(mylikeList)
            mylikeRecyclerView = binding.recyclerItem
            mylikeRecyclerView.adapter = mylikeAdapter
            mylikeRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false)
        }
    }

    override fun onGetmylikeFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d("fail123", "$message")
    }
}