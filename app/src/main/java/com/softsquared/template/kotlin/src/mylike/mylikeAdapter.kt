package com.softsquared.template.kotlin.src.mylike

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
import com.softsquared.template.kotlin.src.mylike.model.mylike
import java.sql.Types.NULL

class mylikeAdapter(private val itemList : ArrayList<mylike>) :
    RecyclerView.Adapter<mylikeAdapter.ViewHolder>(){
    var datas = ArrayList<mylike>()

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        var storeImageUrl1: ImageView = itemView.findViewById(R.id.img_like)
        var storeName: TextView = itemView.findViewById(R.id.txt_name)
        var cheetahDelivery: ImageView = itemView.findViewById(R.id.chita_img)
        var averageStarRating: TextView = itemView.findViewById(R.id.txt_review_num)
        var reviewCount: TextView = itemView.findViewById(R.id.txt_review_count)
        var distance: TextView = itemView.findViewById(R.id.txt_distance)
        var deliveryTime: TextView = itemView.findViewById(R.id.delivery_time)
        var deliveryTip: TextView = itemView.findViewById(R.id.txt_delivery_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_like_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.getContext())
            .load(itemList.get(position).storeImageUrl.get(0))
            .into(holder.storeImageUrl1)
        if(itemList.get(position).cheetahDelivery == "NULL"){
//            Log.d("chita123", "success")
            holder.cheetahDelivery.visibility = GONE
//            Log.d("chita123333", "success123")
        }
        else{
            holder.cheetahDelivery.setImageResource(R.drawable.chita_preview_rev_1)
        }
        holder.storeName.setText(itemList.get(position).storeName)
        holder.averageStarRating.setText(itemList.get(position).averageStarRating.toString())
        holder.reviewCount.setText("("+itemList.get(position).reviewCount.toString()+")")
        holder.deliveryTime.setText(itemList.get(position).averageDeliveryTime)
        holder.distance.setText(itemList.get(position).distance)
        if(itemList.get(position).deliveryTip == "무료배달"){
            holder.deliveryTip.setText(itemList.get(position).deliveryTip)
        }
        else{
            holder.deliveryTip.setText("배달비 "+itemList.get(position).deliveryTip)
        }

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