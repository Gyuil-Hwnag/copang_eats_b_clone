package com.softsquared.template.kotlin.src.delivery_detail

import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.src.delivery_detail.model.menu
import com.softsquared.template.kotlin.src.delivery_detail.model.review

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
        holder.price.setText(itemList.get(position).menuPrice.toString()+"원")
        holder.description.setText(itemList.get(position).menuDescription)


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