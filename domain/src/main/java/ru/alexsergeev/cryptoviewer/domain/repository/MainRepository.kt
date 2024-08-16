package ru.alexsergeev.cryptoviewer.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel

interface MainRepository {
    fun getCoins(): List<CoinDomainModel>
}