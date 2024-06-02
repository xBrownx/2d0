package com.brownx.a2d0.auth.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.brownx.a2d0.auth.presenter.components.LoginScreen
import com.brownx.a2d0.ui.components.TopTitle
import com.brownx.a2d0.ui.theme.softGrey

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */

@Composable
fun AuthScreen() {

    val authViewModel = hiltViewModel<AuthViewModel>()
    val authState by authViewModel.authState.collectAsState()

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopTitle(title = authState.screenTitle)
        }
    ) { pv ->
        Column(
            modifier = Modifier
                .padding(pv)
                .fillMaxSize()
                .background(softGrey),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LoginScreen(
                authViewModel = authViewModel,
                authState = authState
            )
        }
    }
}