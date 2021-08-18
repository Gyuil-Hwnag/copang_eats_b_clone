package com.softsquared.template.kotlin.src.register.model

import com.google.gson.annotations.SerializedName

data class PostRegisterRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("username") val username: String,
    @SerializedName("phonenumber") val phonenumber: String
)