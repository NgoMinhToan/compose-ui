package com.example.project1.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import com.example.project1.nav3.ScreenNav3

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenNav3(modifier: Modifier = Modifier, navBackStack: NavBackStack) {
    var scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {  TopBar(scrollBehavior = scrollBehavior) },
//        bottomBar = { BottomBar(navController = navController) },
        content = {
            Screen(modifier = Modifier.padding(it), navBackStack)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
) {
    TopAppBar(
        modifier=modifier,
        scrollBehavior = scrollBehavior,

        title = {
            Text(
                text = "HOME",
            )
        })

}

@Composable
fun Screen(modifier: Modifier = Modifier,navBackStack: NavBackStack) {
    var textFieldValue by remember { mutableStateOf("") }
    Column (
        modifier = modifier
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
                navBackStack.add(ScreenNav3.Screen1)
            },
        ) {
            Text(text = "GO TO Screen 1")
        }
        Button(
            elevation = null,
            onClick = {
                navBackStack.add(ScreenNav3.Detail(textFieldValue))
            },
        ) {
            Text(text = "GO TO DETAIL")
        }
        Button(
            elevation = null,
            onClick = {
                navBackStack.add(ScreenNav3.Demo)
            },
        ) {
            Text(text = "GO TO DEMO")
        }
        Button(
            elevation = null,
            onClick = {
                navBackStack.add(ScreenNav3.TodoApp)
            },
        ) {
            Text(text = "GO TO TODO APP")
        }
        Button(
            elevation = null,
            onClick = {
                navBackStack.add(ScreenNav3.DiceRollerApp)
            },
        ) {
            Text(text = "GO TO DICE ROLLER APP")
        }
    }
}