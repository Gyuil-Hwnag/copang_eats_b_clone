package com.softsquared.template.kotlin.src.event

import com.softsquared.template.kotlin.config.ApplicationClass
import com.softsquared.template.kotlin.src.event.model.EventResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventService(val view: EventView) {
    fun tryPostEvent(){
        val eventAPI = ApplicationClass.sRetrofit.create(eventAPI::class.java)
        eventAPI.postEvent().enqueue(object :
            Callback<EventResponse> {
            override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                view.onPostEventSuccess(response.body() as EventResponse)
            }

            override fun onFailure(call: Call<EventResponse>, t: Throwable) {
                view.onPostEventFailure(t.message ?: "통신 오류")
            }
        })
    }
}