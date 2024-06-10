package com.brownx.a2d0.groups.presenter

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.brownx.a2d0.groups.presenter.createGroup.CreateGroupDialog
import com.brownx.a2d0.groups.presenter.friends.FriendsScreen
import com.brownx.a2d0.groups.presenter.group.GroupScreen
import com.brownx.a2d0.groups.presenter.groups.GroupsScreen
import com.brownx.a2d0.todo.presenter.createTask.CreateTaskDialog
import com.brownx.a2d0.util.Screen

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */

@Composable
fun GroupsNav(
    navController: NavHostController,
    paddingValues: PaddingValues,
    onCreateGroup: () -> Unit
) {
    NavHost(
        navController = navController,
        route = Screen.Home.Groups.route,
        startDestination = Screen.Home.Groups.Groups.route
    ) {

        composable(
            route = Screen.Home.Groups.Groups.route,
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
            GroupsScreen(
                onCreateGroup = onCreateGroup
            )
        }
        composable(
            route = Screen.Home.Groups.Friends.route,
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
            FriendsScreen()
        }

    }
}