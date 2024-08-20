package ru.alexsergeev.cryptoviewer.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import ru.alexsergeev.cryptoviewer.data.api.ApiService
import ru.alexsergeev.cryptoviewer.data.dao.CoinDao
import ru.alexsergeev.cryptoviewer.data.errors.ApiError
import ru.alexsergeev.cryptoviewer.data.errors.NetworkError
import ru.alexsergeev.cryptoviewer.data.errors.UnknownError
import ru.alexsergeev.cryptoviewer.data.models.CoinDataModelDetail
import ru.alexsergeev.cryptoviewer.data.models.Description
import ru.alexsergeev.cryptoviewer.data.models.Image
import ru.alexsergeev.cryptoviewer.data.utils.DataCoinToDomainCoinMapper
import ru.alexsergeev.cryptoviewer.data.utils.DataCoinDetailToDomainCoinMapper
import ru.alexsergeev.cryptoviewer.data.utils.DomainCoinToEntityCoinMapper
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel
import ru.alexsergeev.cryptoviewer.domain.repository.MainRepository
import java.io.IOException

internal class MainRepositoryImpl(
    private val coinDao: CoinDao,
    private val apiService: ApiService,
    private val dataCoinToDomainCoinMapper: DataCoinToDomainCoinMapper,
    private val dataCoinDetailToDomainCoinMapper: DataCoinDetailToDomainCoinMapper,
    private val domainCoinToEntityCoinMapper: DomainCoinToEntityCoinMapper
) : MainRepository {

    private val cacheCoin = MutableStateFlow<CoinDomainModel>(CoinDomainModel("0", "", "", "", 0, 0, "", listOf()))
    override fun getCoins(vsCurrency: String): Flow<List<CoinDomainModel>> = flow {
        try {
            val response = apiService.getAll(vsCurrency, "30", 1)
            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }
            val coinsDomain = mutableListOf<CoinDomainModel>()
            response.body()?.forEach {
                coinsDomain.add(dataCoinToDomainCoinMapper.map(it))
            }
            coinsDomain.forEach {
                coinDao.insert(domainCoinToEntityCoinMapper.map(it))
            }
            emit(coinsDomain)
        } catch (e: IOException) {
            Log.d("error", "networkError")
        } catch (e: Exception) {
            throw UnknownError
        }
    }

    override fun getCoin(id: String): Flow<CoinDomainModel> = flow {
        if(fetchCoin().value.id != id) {
            try {
                val response = apiService.getCoinById(id)
                if (!response.isSuccessful) {
                    throw ApiError(response.code(), response.message())
                }
                cacheCoin.value =
                    response.body()?.let { dataCoinDetailToDomainCoinMapper.map(it) }!!
                emit(
                    dataCoinDetailToDomainCoinMapper.map(response.body() ?: throw Exception())
                )
            } catch (e: IOException) {
                Log.d("error", "networkError")
            } catch (e: Exception) {
                throw UnknownError
            }
        }
        else {
            emit(cacheCoin.value)
        }
    }
    private fun fetchCoin() = cacheCoin
}