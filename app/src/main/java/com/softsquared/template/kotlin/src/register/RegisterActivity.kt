package com.softsquared.template.kotlin.src.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.softsquared.template.kotlin.config.BaseActivity
import com.softsquared.template.kotlin.databinding.ActivtyRegisterBinding
import com.softsquared.template.kotlin.src.login.LoginActivity
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.register.model.PostRegisterRequest
import com.softsquared.template.kotlin.src.register.model.SignUpResponse

class RegisterActivity : BaseActivity<ActivtyRegisterBinding>(ActivtyRegisterBinding::inflate), RegisterView {

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

        binding.registerBtn.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val username = binding.name.text.toString()
            val phoneNumber = binding.phone.text.toString()
            showCustomToast(phoneNumber)
            val postRequest = PostRegisterRequest(email = email, password = password,
                username = username, phonenumber = "010-0000-0000")
            showLoadingDialog(this)
            RegisterService(this).tryPostRegisterUp(postRequest)
        }
    }

    override fun onPostRegisterSuccess(response: SignUpResponse) {
        dismissLoadingDialog()
        binding.registerBtn.text = response.message
        response.message?.let { showCustomToast(it) }
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        Log.d("success111", "success")
    }

    override fun onPostRegisterFailure(message: String) {
        dismissLoadingDialog()
        showCustomToast("오류 : $message")
        Log.d("fail123", "fail")
    }
}