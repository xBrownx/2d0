package com.brownx.a2d0.auth.presenter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.brownx.a2d0.auth.presenter.AuthState
import com.brownx.a2d0.auth.presenter.AuthUiEvents
import com.brownx.a2d0.auth.presenter.AuthViewModel
import com.brownx.a2d0.ui.components.CustomTextField
import com.brownx.a2d0.ui.theme.softBlue
import com.brownx.a2d0.ui.theme.softOrange
import com.brownx.a2d0.ui.theme.softPink
import com.brownx.a2d0.ui.theme.softYellow

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */

@Composable
fun LoginScreen(
    authViewModel: AuthViewModel,
    authState: AuthState
) {
    Column {

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .background(softBlue)
        ) {
            CustomTextField(
                value = authState.username,
                label = "Username/Mobile"
            ) {
                authViewModel.onEvent(
                    AuthUiEvents.OnUsernameChanged(it)
                )
            }
            CustomTextField(
                value = authState.password,
                label = "Password"
            ) {
                authViewModel.onEvent(
                    AuthUiEvents.OnPasswordChanged(it)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        authViewModel.onEvent(
                            AuthUiEvents.Login
                        )
                    }) {
                    Text(text = authState.screenTitle)
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                Text(
                    text = "Don't have an account? Register ",
                    color = softYellow
                )
                Text(
                    text = "here",
                    color = softOrange
                )
            }
        }
    }
}