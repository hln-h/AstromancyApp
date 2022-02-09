package com.carvalho.astromancy

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface HoroscopeService {

    @POST("?")
    fun getTodayHoroscope(@Query("sign") sign: String, @Query("day") day:String): Call<HoroscopeResponseModel>
}