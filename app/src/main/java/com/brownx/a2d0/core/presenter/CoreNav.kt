package com.brownx.a2d0.core.presenter

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.brownx.a2d0.core.presenter.components.CorePager
import com.brownx.a2d0.createGroup.presenter.CreateGroupScreen
import com.brownx.a2d0.createTask.presenter.CreateTaskScreen
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