package com.softsquared.template.kotlin.src.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentMainBinding
import com.softsquared.template.kotlin.src.location.LocationActivity
import com.softsquared.template.kotlin.src.main.model.Category

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::bind, R.layout.fragment_main){

    lateinit var categoryAdapter: CategoryAdapter
    lateinit var mRecyclerView: RecyclerView
    var categoryList = ArrayList<Category>()

    private val sliderHandler: Handler = Handler()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 광고베너
        val sliderItems: MutableList<String> = ArrayList()
        sliderItems.add("https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg")
        sliderItems.add("https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg")
        sliderItems.add("https://cdn.pixabay.com/photo/2020/11/10/01/34/pet-5728249_1280.jpg")
        sliderItems.add("https://cdn.pixabay.com/photo/2020/12/21/19/05/window-5850628_1280.png")
        sliderItems.add("https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg")
        sliderItems.add("https://cdn.pixabay.com/photo/2019/10/15/13/33/red-deer-4551678_1280.jpg")
        binding.vpImageSlider.setAdapter(SliderAdapter(context!!, binding.vpImageSlider, sliderItems))
        binding.vpImageSlider.setClipToPadding(false)
        binding.vpImageSlider.setClipChildren(false)
        binding.vpImageSlider.setOffscreenPageLimit(3)
        binding.vpImageSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER)
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
//            page.scaleY = 0.85f + r * 0.15f
        }
        binding.vpImageSlider.setPageTransformer(compositePageTransformer)
        binding.vpImageSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 2000)
            }
        })


        // revcycler view
        categoryList.add(Category(R.drawable.img_category1, "신규 맛집"))
        categoryList.add(Category(R.drawable.img_category2, "1인분"))
        categoryList.add(Category(R.drawable.img_category3, "한식"))
        categoryList.add(Category(R.drawable.img_category4, "치킨"))
        categoryList.add(Category(R.drawable.img_category5, "분식"))
        categoryList.add(Category(R.drawable.img_category6, "돈까스"))
        categoryList.add(Category(R.drawable.img_category7, "족발/보쌈"))
        categoryList.add(Category(R.drawable.img_category8, "찜/탕"))
        categoryList.add(Category(R.drawable.img_category9, "구이"))
        categoryList.add(Category(R.drawable.img_category10, "피자"))
        categoryList.add(Category(R.drawable.img_category11, "중식"))
        categoryList.add(Category(R.drawable.img_category12, "일식"))
        categoryList.add(Category(R.drawable.img_category13, "회/해물"))
        categoryList.add(Category(R.drawable.img_category14, "양식"))
        categoryList.add(Category(R.drawable.img_category15, "커피/차"))
        categoryList.add(Category(R.drawable.img_category16, "디저트"))
        categoryList.add(Category(R.drawable.img_category17, "간식"))
        categoryList.add(Category(R.drawable.img_category18, "아시안"))
        categoryList.add(Category(R.drawable.img_category19, "샌드위치"))
        categoryList.add(Category(R.drawable.img_category20, "샐러드"))
        categoryList.add(Category(R.drawable.img_category21, "버거"))
        categoryList.add(Category(R.drawable.img_category22, "멕시칸"))
        categoryList.add(Category(R.drawable.img_category23, "도시락"))
        categoryList.add(Category(R.drawable.img_category24, "죽"))
        categoryList.add(Category(R.drawable.img_category25, "프렌차이즈"))

        categoryAdapter = CategoryAdapter(categoryList)
        mRecyclerView = binding.recyclerItem
        mRecyclerView.adapter = categoryAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,
            false)
//        mRecyclerView.addItemDecoration(VerticalItemDecorator(20))

        binding.locMain.setOnClickListener {
            var intent = Intent(context, LocationActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private val sliderRunnable =
        Runnable { binding.vpImageSlider.setCurrentItem(binding.vpImageSlider.getCurrentItem() + 1) }

    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRunnable)
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable, 2000)
    }
}