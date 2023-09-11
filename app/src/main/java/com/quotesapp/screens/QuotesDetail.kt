package com.quotesapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.quotesapp.model.Quote
import com.quotesapp.utils.DataManager


@Composable
fun QuotesDetail(quote: Quote) {

    BackHandler {
        DataManager.switchPage(null)
    }

    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color.DarkGray, Color.White
                    )
                )
            )
    ) {

        Card(
            elevation = CardDefaults.cardElevation(),
            modifier = Modifier
                .padding(32.dp)
        ) {


            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp, 24.dp)
            ) {

                Image(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Quotes",
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Black)
                )

                Text(
                    text = quote.quote,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Spacer(modifier = Modifier.padding(4.dp))

                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }


}