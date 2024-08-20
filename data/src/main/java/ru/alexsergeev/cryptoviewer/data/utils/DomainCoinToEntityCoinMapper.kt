package ru.alexsergeev.cryptoviewer.data.utils

import ru.alexsergeev.cryptoviewer.data.entity.CoinEntity
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel

internal class DomainCoinToEntityCoinMapper() : Mapper<CoinDomainModel, CoinEntity> {
    override fun map(input: CoinDomainModel): CoinEntity = with(input) {
        CoinEntity(
            id = id,
            symbol = symbol,
            name = name,
            image = image,
            current_price = price.toLong(),
            price_change_percentage_24h = priceChangePercentage24h.toLong(),
        )
    }
}