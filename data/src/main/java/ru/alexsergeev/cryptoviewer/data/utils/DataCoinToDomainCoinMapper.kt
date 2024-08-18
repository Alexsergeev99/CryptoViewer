package ru.alexsergeev.cryptoviewer.data.utils

import ru.alexsergeev.cryptoviewer.data.models.CoinDataModel
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel

internal class DataCoinToDomainCoinMapper() : Mapper<CoinDataModel, CoinDomainModel> {
    override fun map(input: CoinDataModel): CoinDomainModel = with(input) {
        CoinDomainModel(id, symbol, name, image, current_price.toString(), price_change_percentage_24h.toString(), info, categories)
    }
}