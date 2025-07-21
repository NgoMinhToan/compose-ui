package com.example.project1.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoApp(modifier: Modifier = Modifier, navBackStack: NavBackStack) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )
    Scaffold (
        topBar = {
            TodoAppTopBar(scrollBehavior = scrollBehavior)
        },
        bottomBar = {
            TodoAppBottomBar()
        }
    ) { paddingValues ->
        TodoScreen(modifier = Modifier.padding(paddingValues))
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoAppTopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
) {
    TopAppBar(
        modifier=modifier,
        scrollBehavior = scrollBehavior,

        title = {
            Text(
                text = "TODO App",
            )
        })

}

@Composable
fun TodoAppBottomBar(modifier: Modifier = Modifier) {
    BottomAppBar {  }
}

@Composable
fun TodoScreen(modifier: Modifier = Modifier) {

}
