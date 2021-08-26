package com.softsquared.template.kotlin.src.my_cart.model

import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.src.my_cart.UserAddres

data class cartListItem(
    @SerializedName("Coupon List") val Coupon_List: Int,
    @SerializedName("Delivery Tip") val Delivery_Tip: Int,
    @SerializedName("Menu List") val Menu_List: List<Menu>,
    @SerializedName("Order Price") val Order_Price: Int,
    @SerializedName("Total Cost") val Total_Cost: Int,
    @SerializedName("User Address") val User_Address: List<UserAddres>,
//    val Delivery Tip: Int,
//    val Menu List: List<Menu>,
//    val Order Price: Int,
//    val Total Cost: Int,
//    val User Address: List<UserAddres>
)