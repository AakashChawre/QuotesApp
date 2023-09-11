package com.quotesapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.quotesapp.model.Quote

@Composable
fun QuotesScreen(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {

    Column {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.headlineLarge
        )
        QuotesList(data,onClick)
    }
}