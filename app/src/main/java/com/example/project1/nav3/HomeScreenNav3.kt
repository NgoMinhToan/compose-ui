package com.example.project1.nav3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack

@Composable
fun HomeScreenNav3(modifier: Modifier = Modifier, navBackStack: NavBackStack) {
    var textFieldValue by remember { mutableStateOf("") }
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
//        topBar = { TopBar() },
//        bottomBar = { BottomBar(navController = navController) },
        content = {
            Column (
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = textFieldValue,
                    onValueChange = {
                        textFieldValue = it
                    },
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Button(
                    elevation = null,
                    onClick = {
                        navBackStack.add(ScreenNav3.Detail(textFieldValue))
                    },
                ) {
                    Text(text = "GO TO DETAIL")
                }
            }
        }
    )
}