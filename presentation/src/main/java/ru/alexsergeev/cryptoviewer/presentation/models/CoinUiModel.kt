package ru.alexsergeev.cryptoviewer.presentation.models

internal data class CoinUiModel(
    val id: String,
    val title: String,
    val ticker: String,
    val price: String,
    val info: String,
    val categories: List<String>
)
