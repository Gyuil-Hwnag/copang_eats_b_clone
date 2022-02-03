package com.softsquared.template.kotlin.src.event

import com.softsquared.template.kotlin.src.event.model.EventResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface eventAPI {
    @GET("/app/events")
    fun postEvent(): Call<EventResponse>
}
