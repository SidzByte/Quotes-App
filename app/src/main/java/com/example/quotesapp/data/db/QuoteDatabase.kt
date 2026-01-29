package com.example.quotesapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//🧠 Warehouse analogy:
//Room = warehouse
//DAO = worker
//Entity = box
@Database(entities = [QuoteEntity::class], version = 2)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

    companion object {
        fun create(context: Context): QuoteDatabase =
            Room.databaseBuilder(
                context,
                QuoteDatabase::class.java,
                "quote_db"
            ).build()
    }
}