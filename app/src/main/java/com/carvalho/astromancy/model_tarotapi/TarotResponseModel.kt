package com.carvalho.astromancy.model_tarotapi

import com.google.gson.annotations.SerializedName


class TarotResponseModel (
    @SerializedName ("success") var success: Int,
    @SerializedName ("card") var card: String,
    @SerializedName ("category") var category: String, //reversed or not
    @SerializedName ("yes_no") var yesno: String, //yes or no answer
    @SerializedName ("result") var result: String, //tarot message
    @SerializedName ("image2") var cardImage: String,

    )