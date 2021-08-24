package com.example.week6

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.softsquared.template.kotlin.src.main.myPage.Map.MapFragment
import com.softsquared.template.kotlin.src.main.myPage.Sea.SeaFragment
import com.softsquared.template.kotlin.src.order_history.HistoryFragment
import com.softsquared.template.kotlin.src.order_history.NotYetFragment


class OrderHistoryAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    private val NUM_PAGES = 2

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> { return HistoryFragment() }
            else-> { return NotYetFragment() }
        }
    }
}