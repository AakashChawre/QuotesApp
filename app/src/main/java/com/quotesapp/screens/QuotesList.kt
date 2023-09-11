package com.quotesapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.quotesapp.model.Quote

@Composable
fun QuotesList(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {

    LazyColumn(content = {
        items(data) {
            Quote(it,onClick)
        }
    })
}