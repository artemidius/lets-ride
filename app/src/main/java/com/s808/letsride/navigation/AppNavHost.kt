package com.s808.letsride.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.s808.civilian.rides.screen.CivilianRidesScreen
import com.s808.start.ui.host.StartScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Start.route,
        modifier = modifier
    ) {
        composable(route = Start.route) {
            StartScreen(
                onClickCivilianFindRiders = {
                    navController.navigate(CivilianRides.route)
                },
            )
        }

        composable(route = CivilianRides.route) {
            CivilianRidesScreen(
                onClickBack = { navController.popBackStack() },
                onClickFilter = { println("CLICK-FILTER") },
                onClickItem = {
                    println("CLICK-ITEM: $it")
                }
            )
        }
    }
}
