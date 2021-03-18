package me.kvait.currencyrates.Api

import me.kvait.currencyrates.model.CurrencyRates
import retrofit2.Response
import retrofit2.http.GET

interface API {
    @GET("/daily_json.js")
    suspend fun getValute(): CurrencyRates
}