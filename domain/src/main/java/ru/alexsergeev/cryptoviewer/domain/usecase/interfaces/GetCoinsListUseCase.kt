package ru.alexsergeev.cryptoviewer.domain.usecase.interfaces

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel

interface GetCoinsListUseCase {
    operator fun invoke(vsCurrency: String): Flow<List<CoinDomainModel>>
}