package com.example.project1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DetailScreen(modifier: Modifier = Modifier, name: String?) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()){
        Text(text = "Detail Screen, Hello $name!")
    }
}