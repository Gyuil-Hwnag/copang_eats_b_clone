package com.softsquared.template.kotlin.src.register

import android.content.Intent
import android.os.Bundle
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivtyRegisterBinding
import com.softsquared.template.kotlin.src.main.MainActivity

class RegisterActivity : BaseActivity<ActivtyRegisterBinding>(ActivtyRegisterBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.closeBtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.allowAll.setOnClickListener {
            var all_check = binding.allowAll.isChecked
            if(all_check){
                binding.allow1Radio.isChecked = true
                binding.allow2Radio.isChecked = true
                binding.allow3Radio.isChecked = true
                binding.allow4Radio.isChecked = true
                binding.allow5Radio.isChecked = true
            }
            else{
                binding.allow1Radio.isChecked = false
                binding.allow2Radio.isChecked = false
                binding.allow3Radio.isChecked = false
                binding.allow4Radio.isChecked = false
                binding.allow5Radio.isChecked = false
            }
        }


        binding.registerBtn.setOnClickListener {
            var all_checked = binding.allow1Radio.isChecked && binding.allow2Radio.isChecked && binding.allow3Radio.isChecked &&
                    binding.allow4Radio.isChecked && binding.allow5Radio.isChecked
            if(all_checked){
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                showCustomToast("체크목록을 확인하십시오.")
            }
        }
    }
}