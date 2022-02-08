package com.carvalho.astromancy.model_tarotapi

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface TarotService {

    @POST("get_yes_or_no_tarot.php")
    @Headers ("Content-Type: application/json")
    fun GetDailyTarot (@Body api_key:String):Call<ResponseRootModel>

}


//api key 8bf1211fd4b7b94528899de0a43b9fb3
//test this our