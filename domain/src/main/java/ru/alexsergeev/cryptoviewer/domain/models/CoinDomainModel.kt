package ru.alexsergeev.cryptoviewer.domain.models

data class CoinDomainModel(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val price: String,
    val priceChangePercentage24h: String,
    val info: String?,
    val categories: List<String?>?
)