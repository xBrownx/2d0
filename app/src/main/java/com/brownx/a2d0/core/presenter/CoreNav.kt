package com.brownx.a2d0.core.presenter

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
            enterTransition =
            {
                slideIntoContainer(
                    animationSpec = tween(durationMillis = 300, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    animationSpec = tween(durationMillis = 300, easing = EaseOut),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            }
        ) {
            CalendarScreen(paddingValues = paddingValues)
        }

        composable(
            route = Screen.Groups.route,
            enterTransition =
            {
                val slideDirection = when (this.initialState.id) {
                    Screen.Calendar.route -> AnimatedContentTransitionScope.SlideDirection.Start
                    else -> AnimatedContentTransitionScope.SlideDirection.End // default
                }
                slideIntoContainer(
                    animationSpec = tween(durationMillis = 300, easing = EaseIn),
                    towards = slideDirection
                )
            },
            exitTransition = {
                val slideDirection = when (this.targetState.id) {
                    Screen.Calendar.route -> AnimatedContentTransitionScope.SlideDirection.End
                    else -> AnimatedContentTransitionScope.SlideDirection.Start // default
                }
                slideOutOfContainer(
                    animationSpec = tween(durationMillis = 300, easing = EaseOut),
                    towards = slideDirection
                )
            }
        ) {
            GroupsScreen(paddingValues = paddingValues)
        }

        composable(
            route = Screen.List.route,
            enterTransition =
            {
                val slideDirection = when (this.initialState.id) {
                    Screen.Calendar.route -> AnimatedContentTransitionScope.SlideDirection.Start
                    Screen.Groups.route -> AnimatedContentTransitionScope.SlideDirection.Start
                    else -> AnimatedContentTransitionScope.SlideDirection.End
                }
                slideIntoContainer(
                    animationSpec = tween(durationMillis = 300, easing = EaseIn),
                    towards = slideDirection
                )
            },
            exitTransition = {
                val slideDirection = when (this.targetState.id) {
                    Screen.Calendar.route -> AnimatedContentTransitionScope.SlideDirection.End
                    Screen.Groups.route -> AnimatedContentTransitionScope.SlideDirection.End
                    else -> AnimatedContentTransitionScope.SlideDirection.Start // default
                }
                slideOutOfContainer(
                    animationSpec = tween(durationMillis = 300, easing = EaseOut),
                    towards = slideDirection
                )
            }

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