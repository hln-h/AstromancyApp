package com.carvalho.astromancy

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HoroscopeRepository {

    private val BASEURL = "https://aztro.sameerkumar.website/"
    private val retrofit = createRetrofit()
    private val service: HoroscopeService = retrofit.create(HoroscopeService::class.java)

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getTodaysHoroscope(starsign: String): HoroscopeResponseModel? {
        val response = service.getTodayHoroscope("${starsign}", "today").execute()
        return if (response.isSuccessful) {
            response.body()
        } else {
            Log.e("HTTP ERROR TAG", "${response.errorBody()}")
            null
        }

    }
}