package com.example.quotesapp.data.repository

import android.util.Log
import com.example.quotesapp.data.api.QuoteApi
import com.example.quotesapp.data.db.QuoteDao
import com.example.quotesapp.data.db.QuoteEntity
import kotlinx.coroutines.flow.Flow


//🧠 Memory hook:
//Repository = Brain that chooses API or DB

class QuoteRepository(
    private val api: QuoteApi,
    private val dao: QuoteDao
) {

    fun getQuoteFromDb(): Flow<QuoteEntity?> {
        return dao.getLastQuote()
    }

    suspend fun fetchQuoteFromApi() {
        try {
            val response = api.getRandomQuote()
            val entity = QuoteEntity(
                id = response._id,
                content = response.content,
                author = response.author
            )
            dao.insertQuote(entity)
        } catch (e: Exception) {
            Log.e("QuoteRepository", "Error fetching quote", e)
            // Handle error (e.g., show a toast or emit an error state)
        }
    }
}