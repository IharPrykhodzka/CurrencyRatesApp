package me.kvait.currencyrates.model

import com.google.gson.annotations.SerializedName

data class SimpleRate(
    @SerializedName("CharCode")
    var charCode: String,
    @SerializedName("Nominal")
    var nominal: Int,
    @SerializedName("Name")
    var name: String,
    @SerializedName("Value")
    var value: Double
)