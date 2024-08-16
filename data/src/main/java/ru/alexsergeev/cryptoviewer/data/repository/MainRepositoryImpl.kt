package ru.alexsergeev.cryptoviewer.data.repository

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.cryptoviewer.data.mock.coins
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel
import ru.alexsergeev.cryptoviewer.domain.repository.MainRepository

internal class MainRepositoryImpl : MainRepository {
    override fun getCoins(): List<CoinDomainModel> = coins
}