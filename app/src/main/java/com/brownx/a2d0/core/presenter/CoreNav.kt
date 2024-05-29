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
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.brownx.a2d0.calendar.presenter.CalendarScreen
import com.brownx.a2d0.core.presenter.components.CorePager
import com.brownx.a2d0.createGroup.presenter.CreateGroupScreen
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
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CoreNav(
    paddingValues: PaddingValues,
    pagerState: PagerState,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.CoreScreen.route,
    ) {
        composable(
            route = Screen.CoreScreen.route,
            enterTransition = {
                slideIntoContainer(
                    animationSpec = tween(durationMillis = 300),
                    towards = AnimatedContentTransitionScope.SlideDirection.Down
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    animationSpec = tween(durationMillis = 300),
                    towards = AnimatedContentTransitionScope.SlideDirection.Up
                )
            }
        ) {
            CorePager(
                paddingValues = paddingValues,
                pagerState = pagerState
            )
        }

        composable(
            route = Screen.CreateTask.route,
            enterTransition = {
                slideIntoContainer(
                    animationSpec = tween(durationMillis = 300),
                    towards = AnimatedContentTransitionScope.SlideDirection.Up
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    animationSpec = tween(durationMillis = 300),
                    towards = AnimatedContentTransitionScope.SlideDirection.Down
                )
            }
        ) {
            CreateTaskScreen()
        }

        composable(
            route = Screen.CreateGroup.route,
            enterTransition = {
                slideIntoContainer(
                    animationSpec = tween(durationMillis = 300),
                    towards = AnimatedContentTransitionScope.SlideDirection.Up
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    animationSpec = tween(durationMillis = 300),
                    towards = AnimatedContentTransitionScope.SlideDirection.Down
                )
            }
        ) {
            CreateGroupScreen()
        }
    }
}