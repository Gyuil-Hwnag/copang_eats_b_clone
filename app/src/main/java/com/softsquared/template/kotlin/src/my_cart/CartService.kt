package com.softsquared.template.kotlin.src.my_cart

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.my_cart.model.CartResponse
import com.softsquared.template.kotlin.src.mycoupon.model.MyCouponResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartService(val view: CartView) {
    fun tryGetCart(userId: Int){
        val cartAPI = ApplicationClass.sRetrofit.create(CartAPI::class.java)
        cartAPI.getCart(userId).enqueue(object :
            Callback<CartResponse> {
            override fun onResponse(call: Call<CartResponse>, response: Response<CartResponse>) {
                view.onGetCartSuccess(response.body() as CartResponse)
            }

            override fun onFailure(call: Call<CartResponse>, t: Throwable) {
                view.onGetCartFailure(t.message ?: "통신 오류")
            }
        })
    }
}