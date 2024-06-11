package com.brownx.a2d0.main.presenter

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.brownx.a2d0.groups.presenter.createGroup.CreateGroupDialog
import com.brownx.a2d0.todo.presenter.createTask.CreateTaskDialog
import com.brownx.a2d0.util.Screen

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */

@Composable
fun HomeNav(
    navController: NavHostController,
) {
    val mainViewModel = hiltViewModel<MainViewModel>()
    val mainState by mainViewModel.mainState.collectAsState()

    NavHost(
        navController = navController,
        route = Screen.Home.route,
        startDestination = Screen.Home.Home.route
    ) {
        composable(
            route = Screen.Home.Home.route,
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
            HomeScreen(
                coreNavController = navController,
            )
        }


    }
}