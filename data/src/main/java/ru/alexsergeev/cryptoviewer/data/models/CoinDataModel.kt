package ru.alexsergeev.cryptoviewer.data.models

internal data class CoinDataModel(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val current_price: Number,
    val price_change_percentage_24h: Number,
    val description: Description?,
    val categories: List<String?>?
)
internal data class Description(
    val en: String,
    val de: String
)