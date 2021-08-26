package com.softsquared.template.kotlin.src.order_history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.src.delivery_detail.model.review
import com.softsquared.template.kotlin.src.order_history.model.history
import java.text.DecimalFormat

class historyAdapter(private val itemList : ArrayList<history>) :
    RecyclerView.Adapter<historyAdapter.ViewHolder>(){
    var datas = ArrayList<history>()

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        var img: ImageView = itemView.findViewById(R.id.store_img)
        var name: TextView = itemView.findViewById(R.id.store_name)
        var date: TextView = itemView.findViewById(R.id.order_date)
        var state: TextView = itemView.findViewById(R.id.order_state)
//        starRating
        var menulist: TextView = itemView.findViewById(R.id.menulist)
        var sumcount: TextView = itemView.findViewById(R.id.all_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_history_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        @SerializedName("orderId") val orderId: Int,
//        @SerializedName("storeImage") val storeImage: String,
//        @SerializedName("storeName") val storeName: String,
//        @SerializedName("orderDate") val orderDate: String,
//        @SerializedName("orderState") val orderState: String,
//        @SerializedName("starRating") val starRating: Float,
//        @SerializedName("menuList") val menuList: String,
//        @SerializedName("sumCost") val sumCost: Int

        Glide.with(holder.itemView.getContext())
            .load(itemList.get(position).storeImage)
            .into(holder.img)
        holder.name.setText(itemList.get(position).storeName)
//        holder.average_star.rating = itemList.get(position).averageingStar
        holder.date.setText(itemList.get(position).orderDate)
        holder.state.setText(itemList.get(position).orderState)
        if(itemList.get(position).menuList == null){
            holder.menulist.setText("NULL")
        }
        else{
            holder.menulist.setText(itemList.get(position).menuList)
        }
        val t_dec_up = DecimalFormat("#,###")
        var str_change_money_up = t_dec_up.format(itemList.get(position).sumCost)
        holder.sumcount.setText(str_change_money_up+"원")


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