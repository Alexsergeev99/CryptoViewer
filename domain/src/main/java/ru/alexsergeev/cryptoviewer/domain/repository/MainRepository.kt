package ru.alexsergeev.cryptoviewer.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel

interface MainRepository {
    fun getCoins(): Flow<List<CoinDomainModel>>
    fun getCoin(id: Long): Flow<CoinDomainModel>
}