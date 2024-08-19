package ru.alexsergeev.cryptoviewer.domain.usecase.implementation

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel
import ru.alexsergeev.cryptoviewer.domain.repository.MainRepository
import ru.alexsergeev.cryptoviewer.domain.usecase.interfaces.GetCoinsListUseCase

internal class GetCoinsListUseCaseImpl(private val repository: MainRepository) : GetCoinsListUseCase {
    override fun invoke(vsCurrency: String): Flow<List<CoinDomainModel>> = repository.getCoins(vsCurrency)
}