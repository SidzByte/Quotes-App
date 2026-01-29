package com.example.quotesapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

//🧠 Entity = DB row

@Entity(tableName = "quotes")
data class QuoteEntity(
    @PrimaryKey val id: String,
    val content: String,
    val author: String,
    val timestamp: Long = System.currentTimeMillis() // 🕒 Added to track the latest
)