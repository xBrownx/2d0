package com.brownx.a2d0.core.presenter

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.brownx.a2d0.auth.presenter.AuthViewModel
import com.brownx.a2d0.auth.presenter.components.LoginScreen
import com.brownx.a2d0.auth.presenter.components.RegisterScreen
import com.brownx.a2d0.main.presenter.HomeScreen
import com.brownx.a2d0.groups.presenter.group.GroupScreen
import com.brownx.a2d0.groups.presenter.groups.GroupsScreen
import com.brownx.a2d0.main.presenter.MainUiEvents
import com.brownx.a2d0.main.presenter.MainViewModel
import com.brownx.a2d0.util.Screen
import timber.log.Timber

/**
 * @author Andrew Brown
 * created on 28/05/2024
 */
@Composable
fun CoreNav(
    coreViewModel: CoreViewModel
) {
    val mainNavController = rememberNavController()
    val mainViewModel = hiltViewModel<MainViewModel>()
    val mainState by mainViewModel.mainState.collectAsState()
    val authViewModel = hiltViewModel<AuthViewModel>()
    val authState by authViewModel.authState.collectAsState()

    NavHost(
        navController = mainNavController,
        startDestination = Screen.Core.route,
    ) {

        composable(route = Screen.Core.route) {
            CoreScreen(
                coreViewModel.authResultChannel,
                onAuthorized = {
                    Timber.d("AUTHORISED MOTHER FUCKER")
                    mainViewModel.onEvent(
                        MainUiEvents.LoadAllRemoteData
                    )
                    mainNavController.popBackStack()
                    mainNavController.navigate(
                        Screen.Home.route
                    )
                },
                onNotAuthorized = {
                    Timber.d("NOT AUTHORISED MOTHER CUNT")
                    mainNavController.popBackStack()
                    mainNavController.navigate(
                        Screen.Auth.route
                    )
                }
            )
        }

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
                    navController = mainNavController,
                    authViewModel = authViewModel,
                    authState = authState,
                    onAuthorized = {
                        mainNavController.navigate(Screen.Home.route)
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
                    navController = mainNavController,
                    authViewModel = authViewModel,
                    authState = authState
                )
            }
        }

        composable(
            route = Screen.Home.route,
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
            HomeScreen(
                navController = mainNavController
            )
        }

        navigation(
            route = Screen.Home.Groups.route,
            startDestination = Screen.Home.Groups.Groups.route
        ) {
            composable(
                route = Screen.Home.Groups.Groups.route,
            ) {
                GroupsScreen(navController = mainNavController)
            }
            composable(
                route = Screen.Home.Groups.Group.route,
            ) {
                GroupScreen(navController = mainNavController)
            }
        }
    }
}

