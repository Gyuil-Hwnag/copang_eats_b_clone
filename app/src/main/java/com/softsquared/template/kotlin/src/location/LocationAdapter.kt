package com.softsquared.template.kotlin.src.location

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.src.event.EventService
import com.softsquared.template.kotlin.src.location.model.location
import com.softsquared.template.kotlin.src.searchDetail.SearchCateogryActivity

class LocationAdapter(private val itemList : ArrayList<location>) :
    RecyclerView.Adapter<LocationAdapter.ViewHolder>(){
    var datas = ArrayList<location>()

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        var category_img: ImageView = itemView.findViewById(R.id.img_category_loc)
        var category_txt: TextView = itemView.findViewById(R.id.txt_category)
        var category_sub_txt: TextView = itemView.findViewById(R.id.sub_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.loc_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(itemList.get(position).classify == "집"){
            holder.category_img.setImageResource(R.drawable.ic_loc_home_preview_rev_1)
        }
        else if(itemList.get(position).classify == "회사"){
            holder.category_img.setImageResource(R.drawable.ic_loc_office_preview_rev_1)
        }
        else{
            holder.category_img.setImageResource(R.drawable.ic_loc_other_preview_rev_1)
        }
        holder.category_txt.setText(itemList.get(position).basic_address)
        holder.category_sub_txt.setText(itemList.get(position).detail_address)

        holder.itemView.setOnClickListener {
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}