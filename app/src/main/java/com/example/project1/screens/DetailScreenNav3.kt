package com.example.project1.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DetailScreenNav3(modifier: Modifier = Modifier, name: String?) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()){
        Text(text = "Detail Screen From Nav3, Hello $name!")
    }
}