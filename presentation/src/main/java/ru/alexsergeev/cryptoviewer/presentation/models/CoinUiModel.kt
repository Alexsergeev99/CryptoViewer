package ru.alexsergeev.cryptoviewer.presentation.models

internal data class CoinUiModel(
    val id: Long,
    val title: String,
    val ticker: String,
    val priceUSD: String,
    val priceRUB: String,
    val info: String,
    val categories: List<String>
)
