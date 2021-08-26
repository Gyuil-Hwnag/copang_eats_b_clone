package com.softsquared.template.kotlin.src.my_cart

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityMyCartBinding
import com.softsquared.template.kotlin.databinding.ActivityMyCouponBinding
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.my_cart.model.CartResponse
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
import java.util.*

class MyCartActivity : BaseActivity<ActivityMyCartBinding>(ActivityMyCartBinding::inflate), CartView, PayView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)
        var userId = text.getInt("userId", 0)

        CartService(this).tryGetCart(userId)

        val postRequest = PostPayRequest(storeMessage = "양 많이", deliveryMessage = "조심히 와주세요")

        binding.payBtn.setOnClickListener {
            PayService(this).tryPostPay(userId, postRequest)
        }
    }

    override fun onGetCartSuccess(response: CartResponse) {
        Log.d("CartSuccess", "success")
    }

    override fun onGetCartFailure(message: String) {
        Log.d("fail123", "$message")
    }

    override fun onPostPaySuccess(response: PayResponse) {
        Log.d("Paysuccess", "success")
    }

    override fun onPostPayFailure(message: String) {
        Log.d("fail123", "$message")
    }
}