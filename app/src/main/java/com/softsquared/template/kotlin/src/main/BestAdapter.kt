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
import com.softsquared.template.kotlin.src.main.model.best
import com.softsquared.template.kotlin.src.searchDetail.SearchDetailActivity

class BestAdapter(private val itemList : ArrayList<best>) :
    RecyclerView.Adapter<BestAdapter.ViewHolder>(){
    var datas = ArrayList<best>()

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        var best_img: ImageView = itemView.findViewById(R.id.img_best)
        var best_name: TextView = itemView.findViewById(R.id.txt_best)
//        var best_logo: TextView = itemView.findViewById(R.id.txt_category)
        var best_distance: TextView = itemView.findViewById(R.id.txt_best_status)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_best_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.best_img.setImageResource(itemList.get(position).best_Img)
        holder.best_name.setText(itemList.get(position).best_name)
        holder.best_distance.setText(itemList.get(position).best_distance)


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