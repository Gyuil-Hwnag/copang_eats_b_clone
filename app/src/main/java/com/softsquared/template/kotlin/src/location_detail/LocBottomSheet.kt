package com.softsquared.template.kotlin.src.location_detail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.src.loc_add.LocationAddActivity
import com.softsquared.template.kotlin.src.login.LoginActivity
import com.softsquared.template.kotlin.src.register.RegisterActivity

class LocBottomSheet() : BottomSheetDialogFragment(){

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
        view?.findViewById<TextView>(R.id.add_detail_btn)?.setOnClickListener {
            dismiss()
        }

        view?.findViewById<Button>(R.id.dismiss_btn)?.setOnClickListener {
            dismiss()
            var intent = Intent(context, LocationAddActivity::class.java)
            startActivity(intent)
        }
    }
}