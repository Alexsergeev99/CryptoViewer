package ru.alexsergeev.cryptoviewer.presentation.models

internal data class CoinUiModel(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val price: String,
    val priceChangePercentage24h: String,
    val info: String?,
    val categories: List<String?>?
)
