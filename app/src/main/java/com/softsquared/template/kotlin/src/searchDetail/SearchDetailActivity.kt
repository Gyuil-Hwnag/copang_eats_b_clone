package com.softsquared.template.kotlin.src.searchDetail

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityMainBinding
import com.softsquared.template.kotlin.databinding.ActivitySearchDetailBinding


class SearchDetailActivity : BaseActivity<ActivitySearchDetailBinding>(ActivitySearchDetailBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var category_name = intent.getStringExtra("category_name")
        binding.txtCategory.setText(category_name)
        binding.preBtn.setOnClickListener {
            var intent = Intent(this, ActivityMainBinding::class.java)
            startActivity(intent)
        }

        for(i in 0..25){
//            var icon: Int = com.softsquared.template.kotlin.R.drawable.img_category1
            var icon: Int = com.softsquared.template.kotlin.R.drawable.chip_contents
            var newtab = binding.tabLayout.newTab()
            newtab.setIcon(icon)
//            newtab.setText("신규 맛집")
            binding.tabLayout.addTab(newtab)
//            binding.tabLayout.addTab(binding.tabLayout.newTab().setText("$i tab"))
        }

        for (i in 0 until binding.tabLayout.getTabCount()) {
            val tab = (binding.tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
            val p = tab.layoutParams as ViewGroup.MarginLayoutParams
            p.setMargins(Utils.dpToPx(8), 0, Utils.dpToPx(8), 0)
            tab.requestLayout()
        }


    }
}