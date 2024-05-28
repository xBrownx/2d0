package com.brownx.a2d0.core.presenter

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.brownx.a2d0.calendar.presenter.CalendarScreen
import com.brownx.a2d0.createTask.presenter.CreateTaskScreen
import com.brownx.a2d0.groups.presenter.GroupsScreen
import com.brownx.a2d0.profile.presenter.ProfileScreen
import com.brownx.a2d0.settings.presenter.SettingsScreen
import com.brownx.a2d0.todo.presenter.TodoScreen
import com.brownx.a2d0.util.Screen

/**
 * @author Andrew Brown
 * created on 28/05/2024
 */
@Composable
fun CoreNav(
    paddingValues: PaddingValues,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.List.route,
    ) {
        composable(
            route = Screen.Calendar.route,
        ) {
            CalendarScreen(paddingValues = paddingValues)
        }

        composable(
            route = Screen.Groups.route,
        ) {
            GroupsScreen(paddingValues = paddingValues)
        }

        composable(
            route = Screen.List.route,
        ) {
            TodoScreen(paddingValues = paddingValues)
        }

        composable(
            route = Screen.Profile.route,
        ) {
            ProfileScreen(paddingValues = paddingValues)
        }

        composable(
            route = Screen.Settings.route,
        ) {
            SettingsScreen(paddingValues = paddingValues)
        }

        composable(
            route = Screen.CreateTask.route,
        ) {
            CreateTaskScreen(paddingValues = paddingValues)
        }
    }
}