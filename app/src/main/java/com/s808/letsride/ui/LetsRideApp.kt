package com.s808.letsride.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.s808.designsystem.ui.theme.LetsRideTheme
import com.s808.letsride.navigation.AppNavHost
import com.s808.navigation.AppNavigationDestination
import com.s808.letsride.navigation.Start

@Suppress("UNUSED_VARIABLE")
@Composable
fun LetsRideApp() {
    LetsRideTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        var currentScreen: AppNavigationDestination by remember { mutableStateOf(Start) }

        Scaffold { innerPadding ->
            AppNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}