package com.softsquared.template.kotlin.src.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.src.main.model.Category
import com.softsquared.template.kotlin.src.main.model.Coupon
import com.softsquared.template.kotlin.src.searchDetail.SearchDetailActivity

class CouponAdapter(private val itemList : ArrayList<Coupon>) :
    RecyclerView.Adapter<CouponAdapter.ViewHolder>(){
    var datas = ArrayList<Category>()

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        var coupon_img: ImageView = itemView.findViewById(R.id.img_coupon)
        var coupon_name: TextView = itemView.findViewById(R.id.txt_coupon)
//        var coupon_logo: TextView = itemView.findViewById(R.id.txt_category)
        var coupon_price: TextView = itemView.findViewById(R.id.txt_coupon_price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_coupon_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.coupon_img.setImageResource(itemList.get(position).coupon_Img)
        holder.coupon_name.setText(itemList.get(position).coupon_name)
        holder.coupon_price.setText(itemList.get(position).coupon_price)


//        holder.itemView.setOnClickListener {
//            var intent = Intent(holder.itemView?.context, SearchDetailActivity::class.java)
//            val name = itemList.get(position).coupon_name
//            intent.putExtra("category_name", name)
//            ContextCompat.startActivity(holder.itemView.context, intent, null)
//        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}