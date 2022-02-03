package com.softsquared.template.kotlin.src.location_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.annotations.SerializedName
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.config.BaseResponse
import com.softsquared.template.kotlin.src.loc_add.LocationAddActivity
import com.softsquared.template.kotlin.src.login.LoginActivity
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.map.RegisterLocationService
import com.softsquared.template.kotlin.src.map.RegisterLocationView
import com.softsquared.template.kotlin.src.map.model.RegisterLocationRequest
import com.softsquared.template.kotlin.src.menu_detail.model.PostCartRegisterRequest
import com.softsquared.template.kotlin.src.menu_detail.model.cartMenu
import com.softsquared.template.kotlin.src.register.RegisterActivity

class LocBottomSheet() : BottomSheetDialogFragment(), RegisterLocationView {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_bottom_sheet_loc, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val text = activity!!.getSharedPreferences("SOFTSQUARED_TEMPLATE_APP", Context.MODE_PRIVATE)
        var userId = text.getInt("userId", 0)
        view?.findViewById<TextView>(R.id.add_detail_btn)?.setOnClickListener {
            dismiss()
        }

        view?.findViewById<Button>(R.id.dismiss_btn)?.setOnClickListener {
            dismiss()

            var address = text.getString("main_location", null)
            var detailAddress = text.getString("detail_location", null)
            var infoAddress = text.getString("info_location", null)
            var latitude = text.getString("latitude", null)!!.toFloat()
            var longitude = text.getString("longitude", null)!!.toFloat()
            var category = text.getInt("category", 2)

            val postRequest = RegisterLocationRequest(userId = userId, address = address!!, detailAddress = detailAddress!!, infoAddress = infoAddress!!,
                latitude = latitude, longitude = longitude, category = category)
            RegisterLocationService(this).tryPostLogin(postRequest)
            var intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPostRegisterLocationSuccess(response: BaseResponse) {
        Log.d("add_location_success", "success")
    }

    override fun onPostRegisterLocationFailure(message: String) {
        Log.d("fail123", " $message")
    }
}