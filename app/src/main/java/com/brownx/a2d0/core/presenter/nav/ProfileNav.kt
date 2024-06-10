package com.brownx.a2d0.core.presenter.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.brownx.a2d0.profile.presenter.ProfileScreen
import com.brownx.a2d0.util.Screen

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */
@Composable
fun ProfileNav(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        route = Screen.Home.Profile.route,
        startDestination = Screen.Home.Profile.Profile.route
    ) {
        composable(
            route = Screen.Home.Profile.Profile.route,
        ) {
            ProfileScreen()
        }
    }
}