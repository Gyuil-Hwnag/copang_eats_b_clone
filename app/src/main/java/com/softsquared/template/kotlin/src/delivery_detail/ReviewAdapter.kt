package com.softsquared.template.kotlin.src.delivery_detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.src.delivery_detail.model.review

class ReviewAdapter(private val itemList : ArrayList<review>) :
    RecyclerView.Adapter<ReviewAdapter.ViewHolder>(){
    var datas = ArrayList<review>()

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
        var review_img: ImageView = itemView.findViewById(R.id.img_review)
        var review_txt: TextView = itemView.findViewById(R.id.txt_review)
        var average_star: RatingBar = itemView.findViewById(R.id.review_average)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_review_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.getContext())
            .load(itemList.get(position).reviewImg)
            .into(holder.review_img)
        holder.review_txt.setText(itemList.get(position).reviewTxt)
        holder.average_star.rating = itemList.get(position).averageingStar


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