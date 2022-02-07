package com.carvalho.astromancy.model_tarotapi

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

interface TarotService {

    @POST ("get_yes_or_no_tarot.php?")
    fun GetDailyTarot (@Query ("api_key="+"8bf1211fd4b7b94528899de0a43b9fb3") api_key:String): Call<TarotResponseModel>
}


//api key 8bf1211fd4b7b94528899de0a43b9fb3
//test this our