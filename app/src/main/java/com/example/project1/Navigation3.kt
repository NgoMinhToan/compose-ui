package com.example.project1

import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator
import com.example.project1.screens.DemoScreen
import com.example.project1.screens.DetailScreenNav3
import com.example.project1.screens.DiceRollerApp
import com.example.project1.screens.HomeScreenNav3
import com.example.project1.screens.Screen1
import com.example.project1.screens.Screen2
import com.example.project1.screens.TodoApp

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun Navigation3(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(ScreenNav3.Home)
    val listDetailStrategy = rememberListDetailSceneStrategy<NavKey>()

    NavDisplay(
        entryDecorators = listOf(
            // Add the default decorators for managing scenes and saving state
            rememberSceneSetupNavEntryDecorator(),
            rememberSavedStateNavEntryDecorator(),
            // Then add the view model store decorator
//            rememberViewModelStoreNavEntryDecorator()
        ),
        sceneStrategy = listDetailStrategy,
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<ScreenNav3.Home> (
                metadata = ListDetailSceneStrategy.detailPane()
            ) {
                HomeScreenNav3(navBackStack = backStack)
            }
            entry<ScreenNav3.Detail>(
                metadata = ListDetailSceneStrategy.detailPane()
            ) { key ->
                DetailScreenNav3(name = key.name)
            }
            entry<ScreenNav3.Demo>(
                metadata = ListDetailSceneStrategy.detailPane()
            ) {
                DemoScreen(navBackStack = backStack)
            }
            entry<ScreenNav3.Screen1>(
                metadata = ListDetailSceneStrategy.detailPane()
            ) {
                Screen1(navBackStack = backStack)
            }
            entry<ScreenNav3.Screen2>(
                metadata = ListDetailSceneStrategy.detailPane()
            ) {
                Screen2(navBackStack = backStack)
            }
            entry<ScreenNav3.TodoApp>(
                metadata = ListDetailSceneStrategy.detailPane()
            ) {
                TodoApp(navBackStack = backStack)
            }
            entry<ScreenNav3.DiceRollerApp>(
                metadata = ListDetailSceneStrategy.detailPane()
            ) { key ->
                DiceRollerApp(navBackStack = backStack)
            }
        },
//        transitionSpec = {
//            // Slide in from right when navigating forward
//            slideInHorizontally(initialOffsetX = { it }) togetherWith
//                    slideOutHorizontally(targetOffsetX = { -it })
//        },
//        popTransitionSpec = {
//            // Slide in from left when navigating back
//            slideInHorizontally(initialOffsetX = { -it }) togetherWith
//                    slideOutHorizontally(targetOffsetX = { it })
//        },
//        predictivePopTransitionSpec = {
//            // Slide in from left when navigating back
//            slideInHorizontally(initialOffsetX = { -it }) togetherWith
//                    slideOutHorizontally(targetOffsetX = { it })
//        },

        )

}