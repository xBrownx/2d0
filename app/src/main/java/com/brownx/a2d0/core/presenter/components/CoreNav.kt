package com.brownx.a2d0.core.presenter.components

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.brownx.a2d0.auth.presenter.AuthScreen
import com.brownx.a2d0.auth.presenter.AuthViewModel
import com.brownx.a2d0.auth.presenter.components.LoginScreen
import com.brownx.a2d0.auth.presenter.components.RegisterScreen
import com.brownx.a2d0.auth.util.AuthResult
import com.brownx.a2d0.core.presenter.CoreUiEvents
import com.brownx.a2d0.core.presenter.CoreViewModel
import com.brownx.a2d0.core.presenter.HomeScreen
import com.brownx.a2d0.core.presenter.components.CorePager
import com.brownx.a2d0.createGroup.presenter.CreateGroupScreen
import com.brownx.a2d0.createTask.presenter.CreateTaskScreen
import com.brownx.a2d0.groups.presenter.group.GroupScreen
import com.brownx.a2d0.groups.presenter.groups.GroupsScreen
import com.brownx.a2d0.util.Screen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

/**
 * @author Andrew Brown
 * created on 28/05/2024
 */
@Composable
fun CoreNav() {
    val mainNavController = rememberNavController()

    val coreViewModel = hiltViewModel<CoreViewModel>()
    val coreState by coreViewModel.coreState.collectAsState()

    val authViewModel = hiltViewModel<AuthViewModel>()
    val authState by authViewModel.authState.collectAsState()

    NavHost(
        navController = mainNavController,
        startDestination = Screen.Auth.route,
    ) {
        navigation(
            startDestination = Screen.Core.route,
            route = Screen.Auth.route
        ) {

            composable(route = Screen.Core.route) {
                CoreScreen(
                    coreViewModel.authResultChannel,
                    onAuthorized = {
                        coreViewModel.onEvent(
                            CoreUiEvents.LoadAll
                        )
                        mainNavController.popBackStack()
                        mainNavController.navigate(
                            Screen.Core.route
                        )
                    },
                    onNotAuthorized = {
                        mainNavController.popBackStack()
                        mainNavController.navigate(
                            Screen.Auth.route
                        )
                    }
                )
            }

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
                    authViewModel = authViewModel,
                    authState = authState
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

@Composable
fun CoreScreen(
    authResultChannel: Flow<AuthResult<Unit>>,
    onAuthorized: () -> Unit,
    onNotAuthorized: () -> Unit
) {
    LaunchedEffect(true) {
        authResultChannel.collectLatest { result ->
            when (result) {
                is AuthResult.Authorized -> {
                    onAuthorized()
                }

                is AuthResult.SingedOut -> {
                    onNotAuthorized()
                }

                is AuthResult.Unauthorized -> {
                    onNotAuthorized()
                }

                is AuthResult.UnknownError -> {
                    onNotAuthorized()
                }
            }
        }
    }
}