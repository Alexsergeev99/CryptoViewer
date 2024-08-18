package ru.alexsergeev.cryptoviewer.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.alexsergeev.cryptoviewer.data.models.CoinDataModel

internal const val BASE_URL = "https://api.coingecko.com/api/v3/"

internal interface ApiService {
    @GET("coins/markets")
    suspend fun getAll(@Query("vs_currency") vsCurrency: String): Response<List<CoinDataModel>>

}