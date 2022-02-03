package com.softsquared.template.kotlin.src.menu_detail

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.databinding.ActivityMainBinding
import com.softsquared.template.kotlin.databinding.ActivityMenuDetailBinding
import com.softsquared.template.kotlin.src.add_cart.*
import com.softsquared.template.kotlin.src.delivery_detail.DeliveryDetailActivity
import com.softsquared.template.kotlin.src.delivery_detail.DeliveryMenuAdapter
import com.softsquared.template.kotlin.src.delivery_detail.model.review
import com.softsquared.template.kotlin.src.event.EventView
import com.softsquared.template.kotlin.src.like.LikeActivity
import com.softsquared.template.kotlin.src.location.LocationActivity
import com.softsquared.template.kotlin.src.login.LoginActivity
import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.menu_detail.model.PostCartRegisterRequest
import com.softsquared.template.kotlin.src.menu_detail.model.cartMenu
import com.softsquared.template.kotlin.src.mylike.MyLikeActivity
import com.softsquared.template.kotlin.src.mypage.MyPageFragment
import com.softsquared.template.kotlin.src.register.RegisterActivity
import com.softsquared.template.kotlin.src.search.SearchFragment
import java.text.DecimalFormat


class MenuDetailActivity : BaseActivity<ActivityMenuDetailBinding>(ActivityMenuDetailBinding::inflate), CartRegisterView {

    var menuList = ArrayList<cartMenu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // shared preference
        var text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)
        var userId = text.getInt("userId", -1)
//        Log.d("userId")
//        showCustomToast("jwt : "+login_status_jwt)
        Glide.with(this)
            .load(intent.getStringExtra("menu_img"))
            .into(binding.img)

        binding.name.setText(intent.getStringExtra("menu_name").toString())
        var price = intent.getIntExtra("menu_price", 0)
        var new_price = price
        val t_dec_up = DecimalFormat("#,###")
        var str_change_money_up = t_dec_up.format(price)
        binding.subName.setText(intent.getStringExtra("menu_description").toString())
        binding.priceTxt.setText(str_change_money_up+"원")

        binding.cartRegister.setOnClickListener {
//            @SerializedName("storeId") val storeId: Int,
//            @SerializedName("menuCount") val menuCount: Int,
//            @SerializedName("menuId") val menuId: Int,
//            @SerializedName("orderArray") val orderArray: ArrayList<orderArray>
            var orderArray = cartMenu("17", "34")
            var orderArray2= cartMenu("17", "34")
            menuList.add(orderArray)
            var storeId = "5"
//            var menucount = Integer.parseInt(binding.txtCount.text.toString())
//            var menucount = Integer.parseInt(binding.txtCount.text.toString())
            var menucount = "1"
            var menuId = "17"
            val postRequest = PostCartRegisterRequest(userId, storeId, menucount, menuId, menuList)
            CartRegisterService(this).tryPostLogin(postRequest)
        }

        binding.addBtn.setOnClickListener {
            var count: Int = binding.txtCount.text.toString().toInt()
            count = count+1
            new_price+=price
            binding.txtCount.text = count.toString()
        }
        binding.subBtn.setOnClickListener {
            var count: Int = binding.txtCount.text.toString().toInt()
            count = count-1
            if(count == 0){
                count = 1
            }
            binding.txtCount.text = count.toString()
        }
    }


    override fun onPostCartRegisterSuccess(response: BaseResponse) {
        Log.d("addcartSuccess", "success")
        var intent = Intent(this, DeliveryDetailActivity::class.java)
        startActivity(intent)
    }

    override fun onPostCartRegisterFailure(message: String) {
        Log.d("fail123", " $message")
    }
}