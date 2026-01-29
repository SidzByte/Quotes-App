package com.example.quotesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotesapp.data.repository.QuoteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

//📌 UI talks ONLY to ViewModel

class QuoteViewModel(
    private val repository: QuoteRepository
) : ViewModel() {

    val quote = repository.getQuoteFromDb()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            null
        )

    fun loadNewQuote() {
        viewModelScope.launch {
            repository.fetchQuoteFromApi()
        }
    }
}