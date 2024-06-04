package com.brownx.a2d0.auth.presenter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.brownx.a2d0.auth.presenter.AuthState
import com.brownx.a2d0.auth.presenter.AuthUiEvents
import com.brownx.a2d0.auth.presenter.AuthViewModel
import com.brownx.a2d0.ui.components.CustomTextField
import com.brownx.a2d0.ui.components.TopTitle
import com.brownx.a2d0.ui.theme.softBlue
import com.brownx.a2d0.ui.theme.softGrey
import com.brownx.a2d0.util.Screen
import timber.log.Timber

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */

@Composable
fun RegisterScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    authState: AuthState
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopTitle(title = "REGISTER")
        }
    ) { paddingValue ->
        Column(
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxSize()
                .background(softGrey),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Column(
                modifier = Modifier
                    .offset(y = (-50).dp)
            ) {
                Column(
                    modifier = Modifier
                        .shadow(
                            elevation = 32.dp,
                        )
                        .padding(horizontal = 16.dp)
                        .background(
                            color = softBlue,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(vertical = 10.dp)

                ) {
                    CustomTextField(
                        value = authState.username,
                        label = "Username"
                    ) {
                        authViewModel.onEvent(
                            AuthUiEvents.OnUsernameChanged(it)
                        )
                    }
                    CustomTextField(
                        value = authState.mobile,
                        label = "Mobile"
                    ) {
                        authViewModel.onEvent(
                            AuthUiEvents.OnMobileChanged(it)
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
                    CustomTextField(
                        value = authState.confirmPassword,
                        label = "Confirm Password"
                    ) {
                        authViewModel.onEvent(
                            AuthUiEvents.OnConfirmPasswordChanged(it)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(
                            onClick = {
                                authViewModel.onEvent(
                                    AuthUiEvents.Register
                                )
                            }) {
                            Text(text = "REGISTER")
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
                        BottomText(
                            text = "Already have an account? Login here",
                            linkText = "here"
                        ) {
                            navController.navigate(Screen.Auth.Login.route)
                        }
                    }
                }
            }
        }
    }
}
