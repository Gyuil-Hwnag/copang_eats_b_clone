package com.softsquared.template.kotlin.src.main_other

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
import java.sql.Types.NULL

class MainDeliveryAdapter(private val itemList : ArrayList<other>) :
    RecyclerView.Adapter<MainDeliveryAdapter.ViewHolder>(){
    var datas = ArrayList<MainDelivery>()

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        var storeImageUrl1: ImageView = itemView.findViewById(R.id.img_new)
        var storeImageUrl2: ImageView = itemView.findViewById(R.id.img_new1)
        var storeImageUrl3: ImageView = itemView.findViewById(R.id.img_new2)
        var storeName: TextView = itemView.findViewById(R.id.txt_name)
        var cheetahDelivery: ImageView = itemView.findViewById(R.id.chita_img)
        var averageStarRating: TextView = itemView.findViewById(R.id.txt_review_num)
        var reviewCount: TextView = itemView.findViewById(R.id.txt_review_count)
        var distance: TextView = itemView.findViewById(R.id.txt_distance)
        var deliveryTip: TextView = itemView.findViewById(R.id.txt_delivery_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_main_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(itemList.get(position).storeImageUrl.size == 3){
            Glide.with(holder.itemView.getContext())
                .load(itemList.get(position).storeImageUrl.get(0))
                .into(holder.storeImageUrl1)
            Glide.with(holder.itemView.getContext())
                .load(itemList.get(position).storeImageUrl.get(1))
                .into(holder.storeImageUrl2)
            Glide.with(holder.itemView.getContext())
                .load(itemList.get(position).storeImageUrl.get(2))
                .into(holder.storeImageUrl3)
        }
        else{
            holder.storeImageUrl1.getLayoutParams().width = 1000
            holder.storeImageUrl2.visibility = GONE
            holder.storeImageUrl3.visibility = GONE
            Glide.with(holder.itemView.getContext())
                .load(itemList.get(position).storeImageUrl.get(0))
                .into(holder.storeImageUrl1)

        }
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
        holder.distance.setText(itemList.get(position).distance)
        if(itemList.get(position).deliveryTip == "무료배달"){
            holder.deliveryTip.setText(itemList.get(position).deliveryTip)
        }
        else{
            holder.deliveryTip.setText("배달비 "+itemList.get(position).deliveryTip)
        }



        holder.itemView.setOnClickListener {
            var intent = Intent(holder.itemView?.context, DeliveryDetailActivity::class.java)
            val name = itemList.get(position).storeName
            val img = itemList.get(position).storeImageUrl.get(0)
            var time = itemList.get(position).averageDeliveryTime
            val tip = itemList.get(position).deliveryTip
            intent.putExtra("name", name)
            intent.putExtra("img", img)
            intent.putExtra("tip", tip)
            intent.putExtra("time", time)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}