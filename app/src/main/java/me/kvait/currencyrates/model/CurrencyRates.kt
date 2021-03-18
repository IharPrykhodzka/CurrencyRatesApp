package me.kvait.currencyrates.model

import com.google.gson.annotations.SerializedName

data class CurrencyRates(
    @SerializedName("Date")
    val date: String,
    @SerializedName("Valute")
    val valutes: LinkedHashMap<String, SimpleRate>
)