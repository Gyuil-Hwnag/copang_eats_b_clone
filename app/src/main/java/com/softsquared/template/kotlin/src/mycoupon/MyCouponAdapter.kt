package com.softsquared.template.kotlin.src.mycoupon

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.src.main.model.Category
import com.softsquared.template.kotlin.src.mycoupon.model.my_coupon
import com.softsquared.template.kotlin.src.searchDetail.SearchDetailActivity
import java.util.*
import kotlin.collections.ArrayList

class MyCouponAdapter(private val itemList : ArrayList<my_coupon>) :
    RecyclerView.Adapter<MyCouponAdapter.ViewHolder>(){
    var datas = ArrayList<my_coupon>()

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        var couponName: TextView = itemView.findViewById(R.id.name)
        var salePrice: TextView = itemView.findViewById(R.id.price)
        var limitOrderPrice: TextView = itemView.findViewById(R.id.constraint)
        var expirationDate: TextView = itemView.findViewById(R.id.shelf_life)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_my_coupon_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.couponName.setText(itemList.get(position).couponName)
        holder.salePrice.setText(itemList.get(position).salePrice.toString()+"원 할인")
        holder.limitOrderPrice.setText(itemList.get(position).salePrice.toString()+"원 이상")
        holder.expirationDate.setText(itemList.get(position).expirationDate.toString()+"까지")


//        holder.itemView.setOnClickListener {
//            var intent = Intent(holder.itemView?.context, SearchDetailActivity::class.java)
//            val name = itemList.get(position).category_name
//            intent.putExtra("category_name", name)
//            ContextCompat.startActivity(holder.itemView.context, intent, null)
//        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}