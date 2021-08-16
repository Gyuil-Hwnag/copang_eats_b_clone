package com.softsquared.template.kotlin.src.searchDetail

import android.content.Intent
import android.os.Bundle
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivityMainBinding
import com.softsquared.template.kotlin.databinding.ActivitySearchDetailBinding
import com.softsquared.template.kotlin.databinding.ActivtyRegisterBinding

class SearchDetailActivity : BaseActivity<ActivitySearchDetailBinding>(ActivitySearchDetailBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var category_name = intent.getStringExtra("category_name")
        binding.txtCategory.setText(category_name)
        binding.preBtn.setOnClickListener {
            var intent = Intent(this, ActivityMainBinding::class.java)
            startActivity(intent)
        }
    }
}