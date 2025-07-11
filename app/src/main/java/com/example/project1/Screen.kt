package com.example.project1

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object Detail : Screen("detail_screen")

    fun withArgs(vararg args: String): String {
        return when (this) {
            Home -> this.route
            Detail -> buildString {
                append(Detail.route)
                args.forEach { arg ->
                    append("/$arg")
                }
            }
        }
    }


}