package com.example.quotesapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

//📌 DAO = database actions
@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(quote: QuoteEntity)

    // 🕒 Order by timestamp to always get the most recently fetched quote
    @Query("SELECT * FROM quotes ORDER BY timestamp DESC LIMIT 1")
    fun getLastQuote(): Flow<QuoteEntity?>
}