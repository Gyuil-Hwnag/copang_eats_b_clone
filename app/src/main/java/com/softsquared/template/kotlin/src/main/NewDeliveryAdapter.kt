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
import com.softsquared.template.kotlin.src.main.model.new_delivery
import com.softsquared.template.kotlin.src.searchDetail.SearchDetailActivity

class NewDeliveryAdapter(private val itemList : ArrayList<new_delivery>) :
    RecyclerView.Adapter<NewDeliveryAdapter.ViewHolder>(){
    var datas = ArrayList<new_delivery>()

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        var delivery_img: ImageView = itemView.findViewById(R.id.img_new)
        var delivery_txt: TextView = itemView.findViewById(R.id.txt_delivery_name)
        var delivery_distance: TextView = itemView.findViewById(R.id.txt_distance)
        var delivery_status: TextView = itemView.findViewById(R.id.txt_delivery_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_new_delivery_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.delivery_img.setImageResource(itemList.get(position).new_delivery_Img)
        holder.delivery_txt.setText(itemList.get(position).new_delivery_name)
        holder.delivery_distance.setText(itemList.get(position).new_delivery_distance)
        holder.delivery_status.setText(itemList.get(position).new_delivery_status)


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