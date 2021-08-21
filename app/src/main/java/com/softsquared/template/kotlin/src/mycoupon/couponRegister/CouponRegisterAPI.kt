package com.softsquared.template.kotlin.src.mycoupon.couponRegister

import com.softsquared.template.kotlin.src.login.model.PostLoginRequest
import com.softsquared.template.kotlin.src.logout.model.PostLogoutRequest
import com.softsquared.template.kotlin.src.logout.model.LogoutResponse
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.model.CouponRegisterResponse
import com.softsquared.template.kotlin.src.mycoupon.couponRegister.model.PostCouponRegisterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface CouponRegisterAPI {
    @POST("/app/users/{userId}/coupon")
    fun postCouponRegister(@Path("userId") userId: Int,
                           @Body params: PostCouponRegisterRequest): Call<CouponRegisterResponse>
}
