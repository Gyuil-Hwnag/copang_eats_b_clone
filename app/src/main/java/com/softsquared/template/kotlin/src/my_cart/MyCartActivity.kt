package com.softsquared.template.kotlin.src.my_cart

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityMyCartBinding
import com.softsquared.template.kotlin.databinding.ActivityMyCouponBinding
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.CouponRegisterService
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.CouponRegisterView
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.model.CouponRegisterResponse
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.model.PostCouponRegisterRequest
import com.softsquared.template.kotlin.src.mycoupon.model.MyCouponResponse
import com.softsquared.template.kotlin.src.mycoupon.model.my_coupon
import java.util.*

class MyCartActivity : BaseActivity<ActivityMyCartBinding>(ActivityMyCartBinding::inflate){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}