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
import com.softsquared.template.kotlin.src.mylike.MyLikeActivity
import com.softsquared.template.kotlin.src.mypage.MyPageFragment
import com.softsquared.template.kotlin.src.register.RegisterActivity
import com.softsquared.template.kotlin.src.search.SearchFragment


class MenuDetailActivity : BaseActivity<ActivityMenuDetailBinding>(ActivityMenuDetailBinding::inflate), AddCartView {

    var menuList = ArrayList<orderArray>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // shared preference
        var text = getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", MODE_PRIVATE)
        var editor = text.edit()
        var jwt = text.getString("X-ACCESS-TOKEN", null)
        var userId = text.getInt("userIdx", -1)
//        showCustomToast("jwt : "+login_status_jwt)
        Glide.with(this)
            .load(intent.getStringExtra("menu_img"))
            .into(binding.img)

        binding.name.setText(intent.getStringExtra("menu_name").toString())
        var price = intent.getIntExtra("menu_price", 0)
        var new_price = price
        binding.subName.setText(intent.getStringExtra("menu_description").toString())
        binding.priceTxt.setText(price.toString()+"원")

        binding.cartRegister.setOnClickListener {
//            @SerializedName("storeId") val storeId: Int,
//            @SerializedName("menuCount") val menuCount: Int,
//            @SerializedName("menuId") val menuId: Int,
//            @SerializedName("orderArray") val orderArray: ArrayList<orderArray>
            var orderArray = orderArray(13, 14)
            menuList.add(orderArray)
            var storeId = 5
            var menucount = Integer.parseInt(binding.txtCount.text.toString())
            var menuId = 13
            val postRequest = AddCartRequest(storeId, menucount, menuId, menuList)
            AddCartService(this).tryPostAddCart(userId, postRequest)
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

    override fun onPostAddCartSuccess(response: AddCartResponse) {
        Log.d("addcartSuccess", "success")
        var intent = Intent(this, DeliveryDetailActivity::class.java)
        startActivity(intent)
    }

    override fun onPostAddCartFailure(message: String) {
        Log.d("fail123", "fail")
    }
}