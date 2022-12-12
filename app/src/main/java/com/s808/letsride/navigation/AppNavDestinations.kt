package com.s808.letsride.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.s808.civilian.rides.screen.CivilianRidesScreen
import com.s808.navigation.AppNavigationDestination
import com.s808.start.ui.host.StartScreen

/**
 * App navigation destinations
 */
object Start : AppNavigationDestination {
    override val route = "start"
    override val screen: @Composable () -> Unit = { StartScreen() }
}

object CivilianRides : AppNavigationDestination {
    override val route = "civilian-rides"
    @ExperimentalMaterial3Api
    override val screen: @Composable () -> Unit = { CivilianRidesScreen() }
}