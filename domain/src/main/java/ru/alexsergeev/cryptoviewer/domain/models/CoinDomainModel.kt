package ru.alexsergeev.cryptoviewer.domain.models

data class CoinDomainModel(
    val id: Long,
    val title: String,
    val ticker: String,
    val price: String,
    val info: String,
    val categories: List<String>
)