package com.softsquared.template.kotlin.src.delivery_detail

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.src.delivery_detail.model.menu
import com.softsquared.template.kotlin.src.delivery_detail.model.review
import com.softsquared.template.kotlin.src.menu_detail.MenuDetailActivity
import java.text.DecimalFormat

class DeliveryMenuAdapter(private val itemList : ArrayList<menu>) :
    RecyclerView.Adapter<DeliveryMenuAdapter.ViewHolder>(){
    var datas = ArrayList<menu>()

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        var img: ImageView = itemView.findViewById(R.id.img_delivery_menu)
        var name: TextView = itemView.findViewById(R.id.txt_menu_name)
        var price: TextView = itemView.findViewById(R.id.txt_menu_price)
        var description: TextView = itemView.findViewById(R.id.txt_discription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_delivery_menu_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(itemList.get(position).menuImageUrl != null){
            Glide.with(holder.itemView.getContext())
                .load(itemList.get(position).menuImageUrl)
                .into(holder.img)
        }
        else{
            holder.img.visibility = INVISIBLE
        }
        holder.name.setText(itemList.get(position).menuName)
        val t_dec_up = DecimalFormat("#,###")
        var str_change_money_up = t_dec_up.format(itemList.get(position).menuPrice)
        holder.price.setText(str_change_money_up+"원")
        holder.description.setText(itemList.get(position).menuDescription)


        holder.itemView.setOnClickListener {
            var intent = Intent(holder.itemView?.context, MenuDetailActivity::class.java)
            val name = itemList.get(position).menuName
            val price = itemList.get(position).menuPrice
            val img = itemList.get(position).menuImageUrl
            val idx = itemList.get(position).menuIdx
            val description = itemList.get(position).menuDescription
            intent.putExtra("menu_name", name)
            intent.putExtra("menu_price", price)
            intent.putExtra("menu_description", description)
            intent.putExtra("menu_img", img)
            intent.putExtra("menu_idx", idx)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}