package com.s808.navigation

import androidx.compose.runtime.Composable

/**
 * Interface for describing App navigation destinations
 */
interface AppNavigationDestination {
    /**
     * Defines a specific route this destination belongs to.
     * Route is a String that defines the path to your composable.
     * You can think of it as an implicit deep link that leads to a specific destination.
     * Each destination should have a unique route.
     */
    val route: String

    /**
     * Defines destination screen
     */
    val screen: @Composable () -> Unit
}
