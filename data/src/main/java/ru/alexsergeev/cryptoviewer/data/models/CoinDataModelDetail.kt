package ru.alexsergeev.cryptoviewer.data.models


internal data class CoinDataModelDetail(
    val id: String,
    val symbol: String,
    val name: String,
    val image: Image,
    val current_price: Number?,
    val price_change_percentage_24h: Number?,
    val description: Description?,
    val categories: List<String?>?
)

internal data class Image(
    val thumb: String,
    val small: String,
    val large: String,
)