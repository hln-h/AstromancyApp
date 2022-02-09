package com.carvalho.astromancy.model_tarotapi

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface TarotService {

    @POST("get_yes_or_no_tarot.php")
    fun getDailyTarot(@Body requestBody: RequestBody): Call<ResponseRootModel>

}


//api key 8bf1211fd4b7b94528899de0a43b9fb3
//test this our