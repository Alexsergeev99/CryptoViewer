package ru.alexsergeev.cryptoviewer.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.alexsergeev.cryptoviewer.data.dao.CoinDao
import ru.alexsergeev.cryptoviewer.data.entity.CoinEntity

@Database(entities = [CoinEntity::class], version = 1)
internal abstract class AppDb : RoomDatabase() {
    abstract fun coinDao(): CoinDao

    companion object {
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDb::class.java, "app.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

        fun provideDao(db: AppDb) = db.coinDao()
    }
}