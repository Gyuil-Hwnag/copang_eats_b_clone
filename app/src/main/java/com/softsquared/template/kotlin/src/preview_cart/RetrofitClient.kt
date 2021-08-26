package com.softsquared.template.kotlin.src.preview_cart

import com.example.week5_1.RetrofitClient

class RetrofitClient {

    companion object {
        private val retrofitClient: RetrofitClient = RetrofitClient()

        fun getInstance(): RetrofitClient {
            return retrofitClient
        }
    }
}