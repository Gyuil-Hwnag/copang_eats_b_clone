package com.softsquared.template.kotlin.src.search_detail

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivitySearchDetailBinding
import com.softsquared.template.kotlin.src.search_detail.model.SearchResponse
import com.softsquared.template.kotlin.src.search_detail.model.search


class SearchDetailActivity : BaseActivity<ActivitySearchDetailBinding>(ActivitySearchDetailBinding::inflate)
    , SearchDetailView {

    var searchDetailList = ArrayList<search>()
    lateinit var searchDetailAdapter: SearchDetailAdapter
    lateinit var searchDetailRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // shared preference
        var text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)
        var userId = text.getInt("userIdx", -1)

        binding.searchBtn.setOnClickListener {
            var keyword = binding.searchTxt.text.toString()
            SearchDetailService(this).tryGetSearchDetail(userId, keyword)
        }
    }

    override fun onGetSearchDetailSuccess(response: SearchResponse) {
        if(response.result != null){
            for(i in 0..response.result.size-1){
                Log.d("slider", "")
                var storeImageUrl = response.result.get(i).storeImageUrl
                val Imgarr = storeImageUrl.split(",")
                var storeName = response.result.get(i).storeName
                var cheetahDelivery = response.result.get(i).cheetahDelivery
                Log.d("nul123", "success")
                if(cheetahDelivery == null){
                    Log.d("chita:null", "success")
                    cheetahDelivery = "NULL"
                }
                var averageDeliveryTime = response.result.get(i).averageDeliveryTime
                var averageStarRating = response.result.get(i).averageStarRating
                var reviewCount = response.result.get(i).reviewCount
                var distance = response.result.get(i).distance
                var deliveryTip = response.result.get(i).deliveryTip
                var coupon = response.result.get(i).coupon
                var menuList = response.result.get(i).menuList
                var storeStatus = response.result.get(i).storeStatus

                var item: search = search(Imgarr, storeName, cheetahDelivery, averageDeliveryTime, averageStarRating,
                    reviewCount, distance, deliveryTip, coupon, menuList, storeStatus)
                searchDetailList.add(item)
            }
            showCustomToast("성공")
            Log.d("searchDetail!!!", "success")

            searchDetailAdapter = SearchDetailAdapter(searchDetailList)
            searchDetailRecyclerView = binding.recyclerItem
            searchDetailRecyclerView.adapter = searchDetailAdapter
            searchDetailRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false)
        }
    }

    override fun onGetSearchDetailFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d("fail123", "$message")
    }
}