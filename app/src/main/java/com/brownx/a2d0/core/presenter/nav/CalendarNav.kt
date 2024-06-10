package com.brownx.a2d0.core.presenter.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.brownx.a2d0.calendar.presenter.CoreCalendarScreen
import com.brownx.a2d0.util.Screen

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */

@Composable
fun CalendarNav(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        route = Screen.Home.Calendar.route,
        startDestination = Screen.Home.Calendar.Calendar.route,
    ) {
        composable(
            route = Screen.Home.Calendar.Calendar.route,
        ) {
            CoreCalendarScreen(navController)
        }
    }
}