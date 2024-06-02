package com.brownx.a2d0.core.presenter.components

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.brownx.a2d0.auth.presenter.AuthScreen
import com.brownx.a2d0.core.presenter.components.CorePager
import com.brownx.a2d0.createGroup.presenter.CreateGroupScreen
import com.brownx.a2d0.createTask.presenter.CreateTaskScreen
import com.brownx.a2d0.groups.presenter.group.GroupScreen
import com.brownx.a2d0.groups.presenter.groups.GroupsScreen
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
        startDestination = Screen.Auth.route,
    ) {

        navigation(
            startDestination = Screen.CoreScreen.route,
            route = "Authenticated"
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
                    pagerState = pagerState,
                    navController = navController
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
                route = Screen.Group.route,
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
                GroupScreen(navController = navController)
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

        composable(
            route = Screen.Auth.route,
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
            AuthScreen()
        }
    }
}

@Composable
fun GroupNav(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Groups.route,
    ) {
        composable(
            route = Screen.Groups.route,
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
            GroupsScreen(navController = navController)
        }

    }

}