package com.carvalho.astromancy

import com.google.gson.annotations.SerializedName

 class HoroscopeResponseModel {

    @SerializedName("current_date")
    var currentDate: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("compatibility")
    var compatibility: String? = null

    @SerializedName("mood")
    var mood: String? = null

    @SerializedName("color")
    var color: String? = null

    @SerializedName("lucky_number")
    var luckyNumber: Int? = null

    @SerializedName("lucky_time")
    var luckyTime: String? = null
}