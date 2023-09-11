package com.quotesapp.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.quotesapp.screens.Pages.LISTING
import com.quotesapp.ui.theme.QuotesAppTheme
import com.quotesapp.utils.DataManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(10000)
            DataManager.loadFileData(applicationContext)
        }

        setContent {
            QuotesAppTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {
      if (DataManager.currentPage.value == LISTING){
          QuotesScreen(data = DataManager.data) {
              DataManager.switchPage(it)
          }
      }else{
          DataManager.currentQuote?.let { QuotesDetail(quote = it) }
      }
    } else {
        Loading()
    }
}

@Composable
private fun Loading() {
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f)
    ) {
        Text(text = "Loading...", style = MaterialTheme.typography.headlineMedium)
    }
}

enum class Pages {
    LISTING,
    DETAILS
}
