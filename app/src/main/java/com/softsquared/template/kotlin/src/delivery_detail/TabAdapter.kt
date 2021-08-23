package com.example.week6

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.naver.maps.map.MapFragment
import com.softsquared.template.kotlin.databinding.FragmentMainBinding
import com.softsquared.template.kotlin.src.main.MainFragment


class TabAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    private val NUM_PAGES = 2

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> { return MainFragment() }
            else-> { return MapFragment() }
        }
    }
}