package com.s808.letsride.navigation

import androidx.compose.runtime.Composable
import com.s808.civilian.profile.screen.CivilianProfileScreen
import com.s808.navigation.AppNavigationDestination
import com.s808.start.ui.RoleChoiceScreen

/**
 * App navigation destinations
 */
object Start : AppNavigationDestination {
    override val route = "start"
    override val screen: @Composable () -> Unit = { RoleChoiceScreen() }
}

object Civilian : AppNavigationDestination {
    override val route = "civilian"
    override val screen: @Composable () -> Unit = { CivilianProfileScreen() }
}