package com.example.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quotesapp.data.api.RetrofitInstance
import com.example.quotesapp.data.db.QuoteDatabase
import com.example.quotesapp.data.repository.QuoteRepository
import com.example.quotesapp.ui.screen.QuoteScreen
import com.example.quotesapp.ui.theme.QuotesAppTheme
import com.example.quotesapp.viewmodel.QuoteViewModel


//📌 This is manual dependency injection.

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = QuoteDatabase.create(this)
        val repository = QuoteRepository(
            RetrofitInstance.api,
            db.quoteDao()
        )
        val viewModel = QuoteViewModel(repository)

        setContent {
            MaterialTheme {
                QuoteScreen(viewModel)
            }
        }
    }
}
