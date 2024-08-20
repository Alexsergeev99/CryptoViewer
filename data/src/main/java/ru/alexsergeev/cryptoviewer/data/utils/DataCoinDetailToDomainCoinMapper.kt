package ru.alexsergeev.cryptoviewer.data.utils

import ru.alexsergeev.cryptoviewer.data.entity.CoinEntity
import ru.alexsergeev.cryptoviewer.data.models.CoinDataModelDetail
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel

internal class DataCoinDetailToDomainCoinMapper() : Mapper<CoinDataModelDetail, CoinDomainModel> {
    override fun map(input: CoinDataModelDetail): CoinDomainModel = with(input) {
        CoinDomainModel(
            id,
            symbol,
            name,
            image.large,
            current_price ?: 0,
            price_change_percentage_24h ?: 0,
            description?.en,
            categories
        )
    }
}