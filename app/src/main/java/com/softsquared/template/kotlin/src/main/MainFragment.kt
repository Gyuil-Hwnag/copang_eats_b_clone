package com.softsquared.template.kotlin.src.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseFragment
import com.softsquared.template.kotlin.databinding.FragmentMainBinding
import com.softsquared.template.kotlin.src.best.BestAdapter
import com.softsquared.template.kotlin.src.best.BestService
import com.softsquared.template.kotlin.src.best.BestView
import com.softsquared.template.kotlin.src.best.model.BestResponse
import com.softsquared.template.kotlin.src.coupon.CouponAdapter
import com.softsquared.template.kotlin.src.coupon.CouponService
import com.softsquared.template.kotlin.src.coupon.CouponView
import com.softsquared.template.kotlin.src.coupon.model.CouponResponse
import com.softsquared.template.kotlin.src.event.EventService
import com.softsquared.template.kotlin.src.event.EventView
import com.softsquared.template.kotlin.src.event.SliderAdapter
import com.softsquared.template.kotlin.src.event.model.EventResponse
import com.softsquared.template.kotlin.src.location.LocationActivity
import com.softsquared.template.kotlin.src.main.model.Category
import com.softsquared.template.kotlin.src.coupon.model.coupon
import com.softsquared.template.kotlin.src.best.model.best
import com.softsquared.template.kotlin.src.best_nonuser.nonuserBestService
import com.softsquared.template.kotlin.src.best_nonuser.nonuserBestView
import com.softsquared.template.kotlin.src.event.EventAllActivity
import com.softsquared.template.kotlin.src.main_loc.MainLocService
import com.softsquared.template.kotlin.src.main_loc.MainLocView
import com.softsquared.template.kotlin.src.main_loc.model.MainLocResponse
import com.softsquared.template.kotlin.src.main_other.MainDeliveryAdapter
import com.softsquared.template.kotlin.src.main_new.NewDeliveryAdapter
import com.softsquared.template.kotlin.src.main_new.NewDeliveryService
import com.softsquared.template.kotlin.src.main_new.NewDeliveryView
import com.softsquared.template.kotlin.src.main_new.model.NewDeliveryResponse
import com.softsquared.template.kotlin.src.main_new.model.new_delivery
import com.softsquared.template.kotlin.src.main_new_nonuser.nonuserNewDeliveryService
import com.softsquared.template.kotlin.src.main_new_nonuser.nonuserNewDeliveryView
import com.softsquared.template.kotlin.src.main_other.model.other
import com.softsquared.template.kotlin.src.main_other.model.otherResponse
import com.softsquared.template.kotlin.src.main_other.otherService
import com.softsquared.template.kotlin.src.main_other.otherView
import com.softsquared.template.kotlin.src.main_other_nonuser.nonuserotherService
import com.softsquared.template.kotlin.src.main_other_nonuser.nonuserotherView
import com.softsquared.template.kotlin.src.search_detail.SearchDetailActivity
import java.sql.Types.NULL


class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::bind, R.layout.fragment_main),
    EventView, CouponView, BestView, NewDeliveryView, otherView, MainLocView, nonuserBestView, nonuserNewDeliveryView,
    nonuserotherView{

    lateinit var categoryAdapter: CategoryAdapter
    lateinit var mRecyclerView: RecyclerView
    var categoryList = ArrayList<Category>()

    var bestList = ArrayList<best>()
    lateinit var bestAdapter: BestAdapter
    lateinit var bestRecyclerView: RecyclerView

    var couponList = ArrayList<coupon>()
    lateinit var couponAdapter: CouponAdapter
    lateinit var couponRecyclerView: RecyclerView

    var newDeliveryList = ArrayList<new_delivery>()
    lateinit var newDeliveryAdapter: NewDeliveryAdapter
    lateinit var newDeliveryRecyclerView: RecyclerView

    var otherList = ArrayList<other>()
    lateinit var otherAdapter: MainDeliveryAdapter
    lateinit var otherRecyclerView: RecyclerView

    var sliderItems: MutableList<String> = ArrayList()

    private val sliderHandler: Handler = Handler()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = activity!!.getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", Context.MODE_PRIVATE)
        var userId = text.getInt("userId", 0)
        var jwt = text.getString("X-ACCESS-TOKEN", null)
//        var text = sharedElementReturnTransition
//        var userId = text.

        Log.d("Result!!", userId.toString()+" "+jwt)
//        showCustomToast(userId.toString())

        if(userId != 0){
//            showLoadingDialog(context!!)
            Log.d("userId", userId.toString())
            Log.d("X-ACCESS-TOKEN", jwt.toString())
            EventService(this).tryPostEvent(userId)
            CouponService(this).tryGetCoupon(userId)
            BestService(this).tryGetBest(userId)
            NewDeliveryService(this).tryGetNewDelivery(userId)
            otherService(this).tryGetOther(userId)

            var location = text.getString("location" , null)
            if(location == null){
                MainLocService(this).tryGetNewDelivery(userId)
            }
            else{
                binding.locTxt.text = location
            }
        }
        else{
            nonuserBestService(this).tryGetBest(37.563522165046F, 126.99917408401F)
            nonuserNewDeliveryService(this).tryGetNewDelivery(37.563522165046F, 126.99917408401F)
            nonuserotherService(this).tryGetOther(37.563522165046F, 126.99917408401F)
            var location = text.getString("location" , null)
            if(location == null){
                MainLocService(this).tryGetNewDelivery(userId)
            }
            else{
                binding.locTxt.text = location
            }
        }

        binding.eventAllBtn.setOnClickListener {
            var intent = Intent(context, EventAllActivity::class.java)
            startActivity(intent)
        }

        binding.locMain.setOnClickListener {
            if(userId == 0){
                val bottomSheet = BottomSheet()
                bottomSheet.show(getFragmentManager()!!, bottomSheet.tag)
            }
            else{
                var intent = Intent(context, LocationActivity::class.java)
                startActivity(intent)
            }
        }
        binding.searchBtn.setOnClickListener {
            var intent = Intent(context, SearchDetailActivity::class.java)
            startActivity(intent)
        }

        // revcycler view category
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

    override fun onPostEventSuccess(response: EventResponse) {
        // 광고베너

//        var sliderItemArray: JSONObject
//        sliderItems: MutableList<String> = ArrayList()

        for(i in 0..response.result.size-1){
            Log.d("slider", "")
            sliderItems.add(response.result.get(i).eventImageUrl)
        }
//        showCustomToast("성공")
//        Log.d("success123", "success")

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
    }

    override fun onPostEventFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d("fail123", "fail")
    }

    override fun onGetCouponSuccess(response: CouponResponse) {
        for(i in 0..response.result.size-1){
            Log.d("slider", "")
            var coupon_Img = response.result.get(i).storeImageUrl
            var coupon_name = response.result.get(i).storeName
            var coupon_price = response.result.get(i).salePrice
            var coupon: coupon = coupon(coupon_name,coupon_Img, coupon_price)
            couponList.add(coupon)
        }
        showCustomToast("성공")
        Log.d("success123", "success")

        couponAdapter = CouponAdapter(couponList)
        couponRecyclerView = binding.recyclerItemCoupon
        couponRecyclerView.adapter = couponAdapter
        couponRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,
            false)
    }

    override fun onGetCouponFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d("fail123", "fail")
    }

    override fun onGetBestSuccess(response: BestResponse) {
        for(i in 0..response.result.size-1){
            Log.d("slider", "")
            var storeId = response.result.get(i).storeId
            var storeImageUrl = response.result.get(i).storeImageUrl
            var storeName = response.result.get(i).storeName
            var averageStar = response.result.get(i).averageStarRating
            var reviewCount = response.result.get(i).reviewCount
            var distance = response.result.get(i).distance
            var deliveryTip = response.result.get(i).deliveryTip
            var storeStatus = response.result.get(i).storeStatus

            var best: best = best(storeId, storeImageUrl, storeName, averageStar, reviewCount, distance, deliveryTip, storeStatus)
            bestList.add(best)
        }
        showCustomToast("성공")
        Log.d("success123", "success")

        bestAdapter = BestAdapter(bestList)
        bestRecyclerView = binding.recyclerItemBest
        bestRecyclerView.adapter = bestAdapter
        bestRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,
            false)
    }

    override fun onGetBestFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d("fail123", "fail")
    }

    override fun onGetnonuserBestSuccess(response: BestResponse) {
        for(i in 0..response.result.size-1){
            Log.d("slider", "")
            var storeId = response.result.get(i).storeId
            var storeImageUrl = response.result.get(i).storeImageUrl
            var storeName = response.result.get(i).storeName
            var averageStar = response.result.get(i).averageStarRating
            var reviewCount = response.result.get(i).reviewCount
            var distance = response.result.get(i).distance
            var deliveryTip = response.result.get(i).deliveryTip
            var storeStatus = response.result.get(i).storeStatus

            var best: best = best(storeId, storeImageUrl, storeName, averageStar, reviewCount, distance, deliveryTip, storeStatus)
            bestList.add(best)
        }
        showCustomToast("성공")
        Log.d("success123", "success")

        bestAdapter = BestAdapter(bestList)
        bestRecyclerView = binding.recyclerItemBest
        bestRecyclerView.adapter = bestAdapter
        bestRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,
            false)
    }

    override fun onGetnonuserBestFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d("fail123", "fail")
    }

    override fun onGetNewDeliverySuccess(response: NewDeliveryResponse) {
        for(i in 0..response.result.size-1){
            Log.d("slider", "")
            var storeId = response.result.get(i).storeId
            var storeImageUrl = response.result.get(i).storeImageUrl
            var storeName = response.result.get(i).storeName
            var averageStar = response.result.get(i).averageStarRating
            var reviewCount = response.result.get(i).reviewCount
            var distance = response.result.get(i).distance
            var deliveryTip = response.result.get(i).deliveryTip
            var storeStatus = response.result.get(i).storeStatus

            var newDelivery: new_delivery = new_delivery(storeId, storeImageUrl, storeName, averageStar, reviewCount, distance, deliveryTip, storeStatus)
            newDeliveryList.add(newDelivery)
        }
        showCustomToast("성공")
        Log.d("success123", "success")

        newDeliveryAdapter = NewDeliveryAdapter(newDeliveryList)
        newDeliveryRecyclerView = binding.recyclerItemNew
        newDeliveryRecyclerView.adapter = newDeliveryAdapter
        newDeliveryRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,
            false)
    }

    override fun onGetNewDeliveryFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d("fail123", "fail")
    }

    override fun onGetnonuserNewDeliverySuccess(response: NewDeliveryResponse) {
        for(i in 0..response.result.size-1){
            Log.d("slider", "")
            var storeId = response.result.get(i).storeId
            var storeImageUrl = response.result.get(i).storeImageUrl
            var storeName = response.result.get(i).storeName
            var averageStar = response.result.get(i).averageStarRating
            var reviewCount = response.result.get(i).reviewCount
            var distance = response.result.get(i).distance
            var deliveryTip = response.result.get(i).deliveryTip
            var storeStatus = response.result.get(i).storeStatus

            var newDelivery: new_delivery = new_delivery(storeId, storeImageUrl, storeName, averageStar, reviewCount, distance, deliveryTip, storeStatus)
            newDeliveryList.add(newDelivery)
        }
        showCustomToast("성공")
        Log.d("success123", "success")

        newDeliveryAdapter = NewDeliveryAdapter(newDeliveryList)
        newDeliveryRecyclerView = binding.recyclerItemNew
        newDeliveryRecyclerView.adapter = newDeliveryAdapter
        newDeliveryRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,
            false)
    }

    override fun onGetnonuserNewDeliveryFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d("fail123", "fail")
    }

    override fun onGetOtherSuccess(response: otherResponse) {
        for(i in 0..response.result.size-1){
            Log.d("slider", "")
            var storeId = response.result.get(i).storeId
            var storeImageUrl = response.result.get(i).storeImageUrl
            val Imgarr = storeImageUrl.split(",")
            var storeName = response.result.get(i).storeName
            var cheetahDelivery = response.result.get(i).cheetahDelivery
            Log.d("nul123", "success")
            if(cheetahDelivery == null){
                Log.d("chita:null", "success")
                cheetahDelivery = "NULL"
            }
            var averageDeliveryTime = response.result.get(i).averageDeliveryTime
            var averageStarRating = response.result.get(i).averageStarRating
            var reviewCount = response.result.get(i).reviewCount
            var distance = response.result.get(i).distance
            var deliveryTip = response.result.get(i).deliveryTip
            var coupon = response.result.get(i).coupon
            var menuList = response.result.get(i).menuList
            var storeStatus = response.result.get(i).storeStatus

            var item: other = other(storeId, Imgarr, storeName, cheetahDelivery, averageDeliveryTime, averageStarRating,
                reviewCount, distance, deliveryTip, coupon, menuList, storeStatus)
            otherList.add(item)
        }
        showCustomToast("성공")
        Log.d("success123", "success")

        otherAdapter = MainDeliveryAdapter(otherList)
        otherRecyclerView = binding.recyclerItemMain
        otherRecyclerView.adapter = otherAdapter
        otherRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,
            false)
    }

    override fun onGetOtherFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d("fail123", "$message")
    }

    override fun onGetnonuserOtherSuccess(response: otherResponse) {
        for(i in 0..response.result.size-1){
            Log.d("slider", "")
            var storeId = response.result.get(i).storeId
            var storeImageUrl = response.result.get(i).storeImageUrl
            val Imgarr = storeImageUrl.split(",")
            var storeName = response.result.get(i).storeName
            var cheetahDelivery = response.result.get(i).cheetahDelivery
            Log.d("nul123", "success")
            if(cheetahDelivery == null){
                Log.d("chita:null", "success")
                cheetahDelivery = "NULL"
            }
            var averageDeliveryTime = response.result.get(i).averageDeliveryTime
            var averageStarRating = response.result.get(i).averageStarRating
            var reviewCount = response.result.get(i).reviewCount
            var distance = response.result.get(i).distance
            var deliveryTip = response.result.get(i).deliveryTip
            var coupon = response.result.get(i).coupon
            var menuList = response.result.get(i).menuList
            var storeStatus = response.result.get(i).storeStatus

            var item: other = other(storeId, Imgarr, storeName, cheetahDelivery, averageDeliveryTime, averageStarRating,
                reviewCount, distance, deliveryTip, coupon, menuList, storeStatus)
            otherList.add(item)
        }
        showCustomToast("성공")
        Log.d("success123", "success")

        otherAdapter = MainDeliveryAdapter(otherList)
        otherRecyclerView = binding.recyclerItemMain
        otherRecyclerView.adapter = otherAdapter
        otherRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,
            false)
    }

    override fun onGetnonuserOtherFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d("fail123", "$message")
    }

    override fun onGetMainLocSuccess(response: MainLocResponse) {
        var loc_name = response.result.get(0).addressLine
        binding.locTxt.setText(loc_name)
    }

    override fun onGetMainLocFailure(message: String) {
        showCustomToast("오류 : $message")
        Log.d("fail123", "$message")
    }
}