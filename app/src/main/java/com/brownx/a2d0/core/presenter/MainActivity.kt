package com.brownx.a2d0.core.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brownx.a2d0.auth.util.AuthResult
import com.brownx.a2d0.ui.theme._2d0Theme
import com.brownx.a2d0.util.Screen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _2d0Theme {
                val navController = rememberNavController()
                MainScreen(navController)
            }
        }
    }

    @Composable
    fun MainNav() {

        val coreViewModel = hiltViewModel<CoreViewModel>()
        val coreState by coreViewModel.coreState.collectAsState()
        val mainNavController = rememberNavController()

        NavHost(
            navController = mainNavController,
            startDestination = Screen.Auth.route
        ) {
            composable(route = Screen.Core.route) {
                CoreScreenTwo(
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
        }
    }

    @Composable
    fun CoreScreenTwo(
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
}

