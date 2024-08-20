package ru.alexsergeev.cryptoviewer.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.alexsergeev.cryptoviewer.data.entity.CoinEntity

@Dao
internal interface CoinDao {
    @Query("SELECT * FROM CoinEntity ORDER BY roomId DESC")
    fun getAll(): Flow<List<CoinEntity>>

    @Query("SELECT * FROM CoinEntity WHERE id = :roomId")
    fun getEventById(roomId: Int): Flow<CoinEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(coin: CoinEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertList(coins: List<CoinEntity>)

}