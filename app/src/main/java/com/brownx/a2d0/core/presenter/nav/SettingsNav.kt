package com.brownx.a2d0.core.presenter.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.brownx.a2d0.settings.presenter.SettingsScreen
import com.brownx.a2d0.util.Screen

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */

@Composable
fun SettingsNav(
    navController: NavHostController,
    onLogout: () -> Unit
) {
    NavHost(
        navController = navController,
        route = Screen.Home.Settings.route,
        startDestination = Screen.Home.Settings.Settings.route,
    ) {
        composable(
            route = Screen.Home.Settings.Settings.route,
        ) {
            SettingsScreen(
                onLogout = onLogout
            )
        }
    }
}