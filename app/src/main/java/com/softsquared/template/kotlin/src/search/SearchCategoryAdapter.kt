package com.softsquared.template.kotlin.src.search

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

class SearchCategoryAdapter(private val itemList : ArrayList<Category>) :
    RecyclerView.Adapter<SearchCategoryAdapter.ViewHolder>(){
    var datas = ArrayList<Category>()

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        var category_img: ImageView = itemView.findViewById(R.id.img_categery)
        var category_txt: TextView = itemView.findViewById(R.id.txt_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_search_category_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.category_img.setImageResource(itemList.get(position).sea_Img)
        holder.category_txt.setText(itemList.get(position).sea_name)


//        holder.itemView.setOnClickListener {
//            var intent = Intent(holder.itemView?.context, SearchDetailActivity::class.java)
//            val sea_name = itemList.get(position).sea_name
//            val sea_img = itemList.get(position).sea_Img
//            val sea_weather = itemList.get(position).sea_weather
//            intent.putExtra("sea_name", sea_name)
//            intent.putExtra("sea_Img", sea_img)
//            intent.putExtra("sea_weather", sea_weather)
//            ContextCompat.startActivity(holder.itemView.context, intent, null)
//        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}