package ru.alexsergeev.cryptoviewer.domain.usecase.interfaces

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel

interface GetCoinsListUseCase {
    fun invoke(): Flow<List<CoinDomainModel>>

}