package com.softsquared.template.kotlin.src.order_history

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week6.MyPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentHistoryBinding
import com.softsquared.template.kotlin.databinding.FragmentMyPageBinding
import com.softsquared.template.kotlin.databinding.FragmentOrderHistoryBinding
import com.softsquared.template.kotlin.src.best.BestAdapter
import com.softsquared.template.kotlin.src.best.model.best
import com.softsquared.template.kotlin.src.location.LocationActivity
import com.softsquared.template.kotlin.src.location.MyLocationActivity
import com.softsquared.template.kotlin.src.mycoupon.MyCouponActivity
import com.softsquared.template.kotlin.src.mypage.model.UserInfoResponse
import com.softsquared.template.kotlin.src.order_history.model.HistoryResponse
import com.softsquared.template.kotlin.src.order_history.model.history

class HistoryFragment : BaseFragment<FragmentHistoryBinding>(FragmentHistoryBinding::bind, R.layout.fragment_history), HistoryView {

    var historyList = ArrayList<history>()
    lateinit var historyAdapter: historyAdapter
    lateinit var historyRecyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = activity!!.getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", Context.MODE_PRIVATE)
        var userId = text.getInt("userId", 0)
        var jwt = text.getString("X-ACCESS-TOKEN", null)

        HistoryService(this).tryGetMyCoupon(userId)
    }

    override fun onGetHistorySuccess(response: HistoryResponse) {

//        @SerializedName("orderId") val orderId: Int,
//        @SerializedName("storeImage") val storeImage: String,
//        @SerializedName("storeName") val storeName: String,
//        @SerializedName("orderDate") val orderDate: String,
//        @SerializedName("orderState") val orderState: String,
//        @SerializedName("starRating") val starRating: Float,
//        @SerializedName("menuList") val menuList: String,
//        @SerializedName("sumCost") val sumCost: Int

        for(i in 0..response.result.size-1){
            Log.d("slider", "")
            var orderId = response.result.get(i).orderId
            var storeImage = response.result.get(i).storeImage
            var storeName = response.result.get(i).storeName
            var orderDate = response.result.get(i).orderDate
            var orderState = response.result.get(i).orderState
            var starRating = response.result.get(i).starRating
            var menuList = response.result.get(i).menuList
            var sumCost = response.result.get(i).sumCost

            var item: history = history(orderId, storeImage, storeName, orderDate, orderState,
                starRating, menuList, sumCost)
            historyList.add(item)
        }
        showCustomToast("성공")
        Log.d("success123", "success")

        historyAdapter = historyAdapter(historyList)
        historyRecyclerView = binding.recyclerItem
        historyRecyclerView.adapter = historyAdapter
        historyRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,
            false)
    }

    override fun onGetHistoryFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d("fail123", "fail")
    }
}