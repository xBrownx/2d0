package com.brownx.a2d0.core.presenter.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brownx.a2d0.auth.presenter.AuthViewModel
import com.brownx.a2d0.core.presenter.CoreScreen
import com.brownx.a2d0.core.presenter.CoreViewModel
import com.brownx.a2d0.main.presenter.CoreHomeScreen
import com.brownx.a2d0.main.presenter.HomeNav
import com.brownx.a2d0.main.presenter.HomeScreen
import com.brownx.a2d0.main.presenter.MainUiEvents
import com.brownx.a2d0.main.presenter.MainViewModel
import com.brownx.a2d0.util.Screen

/**
 * @author Andrew Brown
 * created on 28/05/2024
 */
@Composable
fun CoreNav(
    coreViewModel: CoreViewModel,
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

        composable(
            route = Screen.Core.route
        ) {
            CoreScreen(
                coreViewModel.authResultChannel,
                onAuthorized = {
                    mainViewModel.onEvent(
                        MainUiEvents.LoadAllRemoteData
                    )
                    mainNavController.popBackStack()
                    mainNavController.navigate(
                        Screen.Home.route
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
        authNav(
            navController = mainNavController,
            authViewModel = authViewModel,
            authState = authState
        )
        
        composable(
            route = Screen.Home.route
        ) {
            CoreHomeScreen(coreNavController = mainNavController)
        }
    }
}

