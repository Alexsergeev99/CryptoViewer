package ru.alexsergeev.cryptoviewer.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.alexsergeev.cryptoviewer.data.mock.coins
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel
import ru.alexsergeev.cryptoviewer.domain.repository.MainRepository

internal class MainRepositoryImpl : MainRepository {
    override fun getCoins(): Flow<List<CoinDomainModel>> = flow {
        emit(coins)
    }

    override fun getCoin(id: Long): Flow<CoinDomainModel> = flow {
        getCoins().collect { coins ->
            val coin = coins.find { id == it.id } ?: throw Exception()
            emit(coin)
        }
    }
}