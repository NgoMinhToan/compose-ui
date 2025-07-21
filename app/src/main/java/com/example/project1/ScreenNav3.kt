package com.example.project1.nav3

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class ScreenNav3: NavKey {

    @Serializable
    data object Home : ScreenNav3()

    @Serializable
    data class Detail(val name: String) : ScreenNav3()

    @Serializable
    data object Demo : ScreenNav3()

    @Serializable
    data object Screen1 : ScreenNav3()

    @Serializable
    data object Screen2 : ScreenNav3()

    @Serializable
    data object TodoApp : ScreenNav3()

    @Serializable
    data object DiceRollerApp : ScreenNav3()
}