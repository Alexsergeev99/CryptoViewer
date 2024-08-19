package ru.alexsergeev.cryptoviewer.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class CoinEntity(
    @PrimaryKey(autoGenerate = true)
    val roomId: Int = 0,
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val current_price: Long,
    val price_change_percentage_24h: Long,
)