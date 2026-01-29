package com.example.quotesapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quotesapp.viewmodel.QuoteViewModel


//🧠 Compose rule:
//State changes → UI updates automatically

@Composable
fun QuoteScreen(viewModel: QuoteViewModel) {

    val quote by viewModel.quote.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        if (quote == null) {
            Text("No quote yet")
        } else {
            Text(
                text = "“${quote!!.content}”",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("- ${quote!!.author}")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { viewModel.loadNewQuote() }) {
            Text("Get Quote")
        }
    }
}
