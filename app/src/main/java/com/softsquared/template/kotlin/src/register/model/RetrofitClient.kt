package com.example.week5_1

import com.softsquared.template.kotlin.src.logout.model.RetrofitClient

class RetrofitClient {

    companion object {
        private val retrofitClient: RetrofitClient = RetrofitClient()

        fun getInstance(): RetrofitClient {
            return retrofitClient
        }
    }
}