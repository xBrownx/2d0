package com.brownx.a2d0.settings.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.brownx.a2d0.auth.util.AuthResult
import com.brownx.a2d0.ui.components.TopTitle
import com.brownx.a2d0.ui.theme.softGrey
import kotlinx.coroutines.flow.collectLatest

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Composable
fun SettingsScreen(
    onLogout: () -> Unit
) {

    val settingsViewModel = hiltViewModel<SettingsViewModel>()

    LaunchedEffect(true) {
        settingsViewModel.logoutResultChannel.collectLatest { result ->
            when (result) {
                is AuthResult.SingedOut -> {
                    onLogout()
                }

                is AuthResult.Authorized -> Unit
                is AuthResult.Unauthorized -> Unit
                is AuthResult.UnknownError -> Unit
            }
        }
    }


    Scaffold(
        modifier = Modifier,
        topBar = {
            TopTitle(title = "SETTINGS")
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(softGrey)
        ) {
            Button(
                onClick = {
                    settingsViewModel.onEvent(
                        SettingsUiEvents.Logout
                    )
                    onLogout()
                }
            ) {
                Text(text = "Logout")
            }
        }
    }
}