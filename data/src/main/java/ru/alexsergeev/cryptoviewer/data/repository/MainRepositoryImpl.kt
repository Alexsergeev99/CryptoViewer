package ru.alexsergeev.cryptoviewer.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.alexsergeev.cryptoviewer.data.api.ApiService
import ru.alexsergeev.cryptoviewer.data.dao.CoinDao
import ru.alexsergeev.cryptoviewer.data.models.CoinDataModelDetail
import ru.alexsergeev.cryptoviewer.data.models.Description
import ru.alexsergeev.cryptoviewer.data.models.Image
import ru.alexsergeev.cryptoviewer.data.utils.DataCoinToDomainCoinMapper
import ru.alexsergeev.cryptoviewer.data.utils.DataCoinDetailToDomainCoinMapper
import ru.alexsergeev.cryptoviewer.data.utils.DomainCoinToEntityCoinMapper
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel
import ru.alexsergeev.cryptoviewer.domain.repository.MainRepository

internal class MainRepositoryImpl(
    private val coinDao: CoinDao,
    private val apiService: ApiService,
    private val dataCoinToDomainCoinMapper: DataCoinToDomainCoinMapper,
    private val dataCoinDetailToDomainCoinMapper: DataCoinDetailToDomainCoinMapper,
    private val domainCoinToEntityCoinMapper: DomainCoinToEntityCoinMapper
) : MainRepository {
    override fun getCoins(vsCurrency: String): Flow<List<CoinDomainModel>> = flow {
        val coinsNew = apiService.getAll(vsCurrency)
        val coinsDomain = mutableListOf<CoinDomainModel>()
        coinsNew.body()?.forEach {
            coinsDomain.add(dataCoinToDomainCoinMapper.map(it))
        }
        coinsDomain.forEach {
            coinDao.insert(domainCoinToEntityCoinMapper.map(it))
        }
        emit(coinsDomain)
    }

    override fun getCoin(id: String): Flow<CoinDomainModel> = flow {
        val coin = apiService.getCoinById(id)
        emit(
            dataCoinDetailToDomainCoinMapper.map(coin.body() ?: throw Exception())
        )
    }
}