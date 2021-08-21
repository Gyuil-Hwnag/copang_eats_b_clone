package com.softsquared.template.kotlin.src.mycoupon

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityMyCouponBinding
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.CouponRegisterService
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.CouponRegisterView
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.model.CouponRegisterResponse
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.model.PostCouponRegisterRequest
import com.softsquared.template.kotlin.src.mycoupon.model.MyCouponResponse
import com.softsquared.template.kotlin.src.mycoupon.model.my_coupon
import java.util.*

class MyCouponActivity : BaseActivity<ActivityMyCouponBinding>(ActivityMyCouponBinding::inflate),
    CouponView, CouponRegisterView {

    var mycouponList = ArrayList<my_coupon>()
    lateinit var myCouponAdapter: MyCouponAdapter
    lateinit var couponRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)

//        showLoadingDialog(this)
        var userId = text.getInt("userId", 0)
        Log.d("userId", userId.toString())
        CouponService(this).tryGetMyCoupon(userId)

        binding.couponRegisterBtn.setOnClickListener {
            showLoadingDialog(this)
            Log.d("userId1111", userId.toString())
            var couponId: Int = Integer.parseInt(binding.couponEdit.text.toString())
            val postRequest = PostCouponRegisterRequest(couponId = couponId)
            CouponRegisterService(this).tryPostCouponRegister(userId, postRequest)
        }
    }

    override fun onGetCouponSuccess(response: MyCouponResponse) {
        if(response.result.size!=0){
            for(i in 0..response.result.size-1){
                Log.d("slider", "")
                var couponName = response.result.get(i).couponName
                var salePrice = response.result.get(i).salePrice
                var limitOrderPrice = response.result.get(i).limitOrderPrice
                var expirationDate = response.result.get(i).expirationDate
                var my_coupon = my_coupon(couponName,salePrice, limitOrderPrice, expirationDate)
                mycouponList.add(my_coupon)
            }
            myCouponAdapter = MyCouponAdapter(mycouponList)
            couponRecyclerView = binding.itemRecycler
            couponRecyclerView.adapter = myCouponAdapter
            couponRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false)
        }
        showCustomToast("성공")
        Log.d("success123", "success")
    }

    override fun onGetCouponFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d("fail123", "fail")
    }

    override fun onPostCouponRegisterSuccess(response: CouponRegisterResponse) {
        dismissLoadingDialog()
//        binding.couponEdit.text = response.message.toString()
        response.message?.let { showCustomToast(it) }
        Log.d("success!!!", "success")
    }

    override fun onPostCouponRegisterFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
        Log.d("fail123", "fail")
//        var intent = Intent(this, SplashActivity::class.java)
//        startActivity(intent)
    }
}