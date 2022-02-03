package com.softsquared.template.kotlin.src.my_cart

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.src.best.model.best
import com.softsquared.template.kotlin.src.delivery_detail.DeliveryDetailActivity
import com.softsquared.template.kotlin.src.main.model.MainDelivery
import com.softsquared.template.kotlin.src.main_other.model.other
import com.softsquared.template.kotlin.src.my_cart.model.Menu
import java.sql.Types.NULL
import java.text.DecimalFormat

class MyCartAdapter(private val itemList : ArrayList<Menu>) :
    RecyclerView.Adapter<MyCartAdapter.ViewHolder>(){
    var datas = ArrayList<Menu>()

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        var menu_name: TextView = itemView.findViewById(R.id.menu_txt)
        var menu_price: TextView = itemView.findViewById(R.id.price_txt)
        var count: TextView = itemView.findViewById(R.id.count_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_my_cart_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.menu_name.setText(itemList.get(position).menuName)
        val t_dec_up = DecimalFormat("#,###")
        var str_change_money_up = t_dec_up.format(itemList.get(position).menuPrice)
        holder.menu_price.setText(str_change_money_up+"원")
        holder.count.setText(itemList.get(position).menuCount.toString())

//        holder.itemView.setOnClickListener {
//            var intent = Intent(holder.itemView?.context, DeliveryDetailActivity::class.java)
//            val name = itemList.get(position).storeName
//            val img = itemList.get(position).storeImageUrl.get(0)
//            var time = itemList.get(position).averageDeliveryTime
//            val tip = itemList.get(position).deliveryTip
//            intent.putExtra("name", name)
//            intent.putExtra("img", img)
//            intent.putExtra("tip", tip)
//            intent.putExtra("time", time)
//            ContextCompat.startActivity(holder.itemView.context, intent, null)
//        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}