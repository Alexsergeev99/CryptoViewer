package ru.alexsergeev.cryptoviewer.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.alexsergeev.cryptoviewer.data.BuildConfig
import ru.alexsergeev.cryptoviewer.data.models.CoinDataModel
import ru.alexsergeev.cryptoviewer.data.models.CoinDataModelDetail
import java.util.concurrent.TimeUnit

internal const val BASE_URL = "https://api.coingecko.com/api/v3/"

internal interface ApiService {
    @GET("coins/markets")
    suspend fun getAll(
        @Query("vs_currency") vsCurrency: String,
        @Query("per_page") perPage: String,
        @Query("page") page: Int ): Response<List<CoinDataModel>>

    @GET("coins/{id}")
    suspend fun getCoinById(@Path("id") id: String): Response<CoinDataModelDetail>
}

internal fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(100, TimeUnit.SECONDS)
        .build()
} else OkHttpClient
    .Builder()
    .connectTimeout(100, TimeUnit.SECONDS)
    .build()

internal fun provideRetrofit(
    okHttpClient: OkHttpClient,
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

internal fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)