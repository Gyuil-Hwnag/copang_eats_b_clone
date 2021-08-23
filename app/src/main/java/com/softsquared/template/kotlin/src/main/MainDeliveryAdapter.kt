package com.softsquared.template.kotlin.src.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.src.best.model.best
import com.softsquared.template.kotlin.src.delivery_detail.DeliveryDetailActivity
import com.softsquared.template.kotlin.src.main.model.MainDelivery

class MainDeliveryAdapter(private val itemList : ArrayList<MainDelivery>) :
    RecyclerView.Adapter<MainDeliveryAdapter.ViewHolder>(){
    var datas = ArrayList<MainDelivery>()

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        var storeImageUrl: ImageView = itemView.findViewById(R.id.img_new)
        var storeName: TextView = itemView.findViewById(R.id.txt_name)
//        var cheetahDelivery: TextView = itemView.findViewById(R.id.txt_best)
        var averageStarRating: TextView = itemView.findViewById(R.id.txt_review_num)
        var reviewCount: TextView = itemView.findViewById(R.id.txt_review_count)
        var distance: TextView = itemView.findViewById(R.id.txt_distance)
        var deliveryTip: TextView = itemView.findViewById(R.id.txt_delivery_status)
//        var storeStatus: TextView = itemView.findViewById(R.id.txt_best)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_main_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.getContext())
            .load(itemList.get(position).storeImageUrl)
            .into(holder.storeImageUrl)
        holder.storeName.setText(itemList.get(position).storeName)
        holder.averageStarRating.setText(itemList.get(position).averageStarRating.toString())
        holder.reviewCount.setText(itemList.get(position).reviewCount.toString())
        holder.distance.setText(itemList.get(position).distance.toString()+"Km")
        holder.deliveryTip.setText("배달비 "+itemList.get(position).deliveryTip+"원")


        holder.itemView.setOnClickListener {
            var intent = Intent(holder.itemView?.context, DeliveryDetailActivity::class.java)
//            val name = itemList.get(position).coupon_name
//            intent.putExtra("category_name", name)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}