package com.softsquared.template.kotlin.src.coupon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.src.coupon.model.coupon

class CouponAdapter(private val itemList : ArrayList<coupon>) :
    RecyclerView.Adapter<CouponAdapter.ViewHolder>(){
    var datas = ArrayList<coupon>()

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        var storeImageUrl: ImageView = itemView.findViewById(R.id.img_coupon)
        var storeName: TextView = itemView.findViewById(R.id.txt_coupon)
//        var coupon_logo: TextView = itemView.findViewById(R.id.txt_category)
        var salePrice: TextView = itemView.findViewById(R.id.txt_coupon_price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_coupon_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(holder.itemView.getContext())
            .load(itemList.get(position).storeImageUrl)
            .into(holder.storeImageUrl)

        holder.storeName.setText(itemList.get(position).storeName)
        holder.salePrice.setText(itemList.get(position).salePrice.toString()+"원 할인")


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