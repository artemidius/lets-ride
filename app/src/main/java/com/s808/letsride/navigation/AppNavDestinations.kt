package com.s808.letsride.navigation

import androidx.compose.runtime.Composable
import com.s808.civilian.profile.screen.CivilianProfileScreen
import com.s808.civilian.rides.screen.CivilianRidesScreen
import com.s808.navigation.AppNavigationDestination
import com.s808.start.ui.RoleChoiceScreen

/**
 * App navigation destinations
 */
object Start : AppNavigationDestination {
    override val route = "start"
    override val screen: @Composable () -> Unit = { RoleChoiceScreen() }
}

object CivilianProfile : AppNavigationDestination {
    override val route = "civilian-profile"
    override val screen: @Composable () -> Unit = { CivilianProfileScreen() }
}

object CivilianRides : AppNavigationDestination {
    override val route = "civilian-rides"
    override val screen: @Composable () -> Unit = { CivilianRidesScreen() }
}