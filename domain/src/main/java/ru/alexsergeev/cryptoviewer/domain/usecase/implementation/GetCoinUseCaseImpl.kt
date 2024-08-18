package ru.alexsergeev.cryptoviewer.domain.usecase.implementation

import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel
import ru.alexsergeev.cryptoviewer.domain.repository.MainRepository
import ru.alexsergeev.cryptoviewer.domain.usecase.interfaces.GetCoinUseCase
import ru.alexsergeev.cryptoviewer.domain.usecase.interfaces.GetCoinsListUseCase

internal class GetCoinUseCaseImpl(private val repository: MainRepository) :
    GetCoinUseCase {
    override fun invoke(id: String): Flow<CoinDomainModel> = repository.getCoin(id)
}