package ru.alexsergeev.cryptoviewer.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.alexsergeev.cryptoviewer.data.api.ApiService
import ru.alexsergeev.cryptoviewer.data.utils.DataCoinToDomainCoinMapper
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel
import ru.alexsergeev.cryptoviewer.domain.repository.MainRepository

internal class MainRepositoryImpl(
    private val apiService: ApiService,
    private val dataCoinToDomainCoinMapper: DataCoinToDomainCoinMapper
) : MainRepository {
    override fun getCoins(): Flow<List<CoinDomainModel>> = flow {
        val coinsNew = apiService.getAll("usd")
        val coinsDomain = mutableListOf<CoinDomainModel>()
        coinsNew.body()?.forEach {
            coinsDomain.add(dataCoinToDomainCoinMapper.map(it))
        }
        emit(coinsDomain)
    }

    override fun getCoin(id: String): Flow<CoinDomainModel> = flow {
        getCoins().collect { coins ->
            val coin = coins.find { id == it.id } ?: throw Exception()
            emit(coin)
        }
    }
}