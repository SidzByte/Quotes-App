package com.example.quotesapp.data.api

import com.example.quotesapp.data.model.QuoteDto
import retrofit2.http.GET

//📌 No logic here. Just definition.
interface QuoteApi {

    @GET("random")
    suspend fun getRandomQuote(): QuoteDto
}