package ru.alexsergeev.cryptoviewer.presentation.utils

import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel
import ru.alexsergeev.cryptoviewer.presentation.models.CoinUiModel

internal class DomainCoinToUiCoinMapper() : Mapper<CoinDomainModel, CoinUiModel> {
    override fun map(input: CoinDomainModel): CoinUiModel = with(input) {
        CoinUiModel(id, symbol, name, image, price, priceChangePercentage24h, info, categories)
    }
}