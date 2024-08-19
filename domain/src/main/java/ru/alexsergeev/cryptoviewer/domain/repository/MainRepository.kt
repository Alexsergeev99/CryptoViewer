package ru.alexsergeev.cryptoviewer.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel

interface MainRepository {
    fun getCoins(vsCurrency: String): Flow<List<CoinDomainModel>>
    fun getCoin(id: String): Flow<CoinDomainModel>
}