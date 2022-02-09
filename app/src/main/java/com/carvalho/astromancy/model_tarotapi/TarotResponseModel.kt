package com.carvalho.astromancy.model_tarotapi

import com.google.gson.annotations.SerializedName

data class TarotRequestModel(
    @SerializedName("api_key")
    val api_key: String
)


data class ResponseRootModel(val data:TarotResponseModel)


data class TarotResponseModel(
    @SerializedName("card")
    var card: String,
    @SerializedName("category")
    var category: String, //reversed or not
    @SerializedName("yes_no")
    var yesno: String, //yes or no answer
    @SerializedName("result")
    var result: String, //tarot message
    @SerializedName("image2")
    var cardImage: String

)

/*
class Success (
    @SerializedName("success")
    var success: Int,
        )*/