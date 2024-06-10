package com.brownx.a2d0.core.presenter.nav

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.brownx.a2d0.auth.presenter.AuthState
import com.brownx.a2d0.auth.presenter.AuthViewModel
import com.brownx.a2d0.auth.presenter.components.LoginScreen
import com.brownx.a2d0.auth.presenter.components.RegisterScreen
import com.brownx.a2d0.util.Screen

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */

fun NavGraphBuilder.authNav(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    authState: AuthState
) {
    navigation(
        startDestination = Screen.Auth.Login.route,
        route = Screen.Auth.route
    ) {
        composable(
            route = Screen.Auth.Login.route,
            enterTransition = {
                slideIntoContainer(
                    animationSpec = tween(durationMillis = 300),
                    towards = AnimatedContentTransitionScope.SlideDirection.Right
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    animationSpec = tween(durationMillis = 300),
                    towards = AnimatedContentTransitionScope.SlideDirection.Left
                )
            }
        ) {
            LoginScreen(
                navController = navController,
                authViewModel = authViewModel,
                authState = authState,
                onAuthorized = {
                    navController.navigate(Screen.Home.route)
                }
            )
        }

        composable(
            route = Screen.Auth.Register.route,
            enterTransition = {
                slideIntoContainer(
                    animationSpec = tween(durationMillis = 300),
                    towards = AnimatedContentTransitionScope.SlideDirection.Left
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    animationSpec = tween(durationMillis = 300),
                    towards = AnimatedContentTransitionScope.SlideDirection.Right
                )
            }
        ) {
            RegisterScreen(
                navController = navController,
                authViewModel = authViewModel,
                authState = authState,
                onAuthorized = {
                    navController.navigate(Screen.Home.route)
                }
            )
        }
    }
}