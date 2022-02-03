package com.softsquared.template.kotlin.src.my_cart

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityMyCartBinding
import com.softsquared.template.kotlin.databinding.ActivityMyCouponBinding
import com.softsquared.template.kotlin.src.delivery_detail.model.menu
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main_other.MainDeliveryAdapter
import com.softsquared.template.kotlin.src.main_other.model.other
import com.softsquared.template.kotlin.src.my_cart.model.CartResponse
import com.softsquared.template.kotlin.src.my_cart.model.Menu
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.CouponRegisterService
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.CouponRegisterView
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.model.CouponRegisterResponse
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.model.PostCouponRegisterRequest
import com.softsquared.template.kotlin.src.mycoupon.model.MyCouponResponse
import com.softsquared.template.kotlin.src.mycoupon.model.my_coupon
import com.softsquared.template.kotlin.src.pay.PayService
import com.softsquared.template.kotlin.src.pay.PayView
import com.softsquared.template.kotlin.src.pay.model.PayResponse
import com.softsquared.template.kotlin.src.pay.model.PostPayRequest
import java.text.DecimalFormat
import java.util.*

class MyCartActivity : BaseActivity<ActivityMyCartBinding>(ActivityMyCartBinding::inflate), CartView, PayView{

    var cartList = ArrayList<Menu>()
    lateinit var mycartAdapter: MyCartAdapter
    lateinit var cartRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)
        var userId = text.getInt("userId", 0)

        var menuName = "자메이카 통다리"
        var menuPrice = 20000
        var menuCount = 1

        var item: Menu = Menu(menuCount, menuName, menuPrice, 5)
        cartList.add(item)

        mycartAdapter = MyCartAdapter(cartList)
        cartRecyclerView = binding.recyclerItem
        cartRecyclerView.adapter = mycartAdapter
        cartRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
            false)
//        CartService(this).tryGetCart(userId)

        val postRequest = PostPayRequest(storeMessage = "양 많이", deliveryMessage = "조심히 와주세요")

        binding.payBtn.setOnClickListener {
            PayService(this).tryPostPay(userId, postRequest)
        }
    }

    override fun onGetCartSuccess(response: CartResponse) {
        Log.d("CartSuccess", response.result.toString())

//        for(i in 0..response.result.get(1).Menu_List.size-1){
//            if(response.result.get(1).Menu_List.get(i) != null){
//                var items = response.result.get(1).Menu_List.get(i)
//                var menuName = items.menuName
//                var menuPrice = items.menuPrice
//                var menuCount = items.menuCount
//
//                var item: Menu = Menu(menuCount, menuName, menuPrice, items.storeId)
//                cartList.add(item)
//            }
//        }
//
//        mycartAdapter = MyCartAdapter(cartList)
//        cartRecyclerView = binding.recyclerItem
//        cartRecyclerView.adapter = mycartAdapter
//        cartRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
//            false)
    }

    override fun onGetCartFailure(message: String) {
        Log.d("fail123", "$message")
    }

    override fun onPostPaySuccess(response: PayResponse) {
        Log.d("Paysuccess", "success")
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onPostPayFailure(message: String) {
        Log.d("fail123", "$message")
    }
}