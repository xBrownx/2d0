package com.brownx.a2d0.auth.presenter.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.brownx.a2d0.auth.presenter.AuthState
import com.brownx.a2d0.auth.presenter.AuthUiEvents
import com.brownx.a2d0.auth.presenter.AuthViewModel
import com.brownx.a2d0.auth.util.AuthResult
import com.brownx.a2d0.ui.components.CustomTextField
import com.brownx.a2d0.ui.components.TopTitle
import com.brownx.a2d0.ui.theme.softBlue
import com.brownx.a2d0.ui.theme.softGrey
import com.brownx.a2d0.ui.theme.softOrange
import com.brownx.a2d0.ui.theme.softPink
import com.brownx.a2d0.ui.theme.softYellow
import com.brownx.a2d0.util.Screen
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */

@Composable
fun LoginScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    authState: AuthState,
    onAuthorized: () -> Unit,
) {
    val context = LocalContext.current
    LaunchedEffect(true) {
        authViewModel.authResultChannel.collectLatest { result ->
            when (result) {
                is AuthResult.Authorized -> {
                    onAuthorized()
                }

                is AuthResult.UnknownError -> {
                    Toast.makeText(
                        context,
                        "ERROR",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is AuthResult.SingedOut -> {}
                is AuthResult.Unauthorized -> {}
            }
        }
    }

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopTitle(title = "LOGIN")
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
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(
                            onClick = {
                                authViewModel.onEvent(
                                    AuthUiEvents.Login
                                )
                            }) {
                            Text(text = "LOGIN")
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
                            text = "Don't have an account? Get one here",
                            linkText = "here"
                        ) {
                            navController.navigate(Screen.Auth.Register.route)
                        }
                    }
                }
            }
        }
    }
}

