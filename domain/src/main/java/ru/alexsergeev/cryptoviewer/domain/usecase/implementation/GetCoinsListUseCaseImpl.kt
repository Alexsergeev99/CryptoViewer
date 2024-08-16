package ru.alexsergeev.cryptoviewer.domain.usecase.implementation

import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel
import ru.alexsergeev.cryptoviewer.domain.repository.MainRepository
import ru.alexsergeev.cryptoviewer.domain.usecase.interfaces.GetCoinsListUseCase

internal class GetCoinsListUseCaseImpl(val repository: MainRepository) :
    GetCoinsListUseCase {

}