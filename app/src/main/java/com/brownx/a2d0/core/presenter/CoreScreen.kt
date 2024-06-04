package com.brownx.a2d0.core.presenter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.brownx.a2d0.auth.util.AuthResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */
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
                    Timber.d("AuthResult.Authorized")
                    onAuthorized()
                }

                is AuthResult.SingedOut -> {
                    Timber.d("AuthResult.SingedOut")
                    onNotAuthorized()
                }

                is AuthResult.Unauthorized -> {
                    Timber.d("AuthResult.Unauthorized")
                    onNotAuthorized()
                }

                is AuthResult.UnknownError -> {
                    Timber.d("AuthResult.UnknownError")
                    onNotAuthorized()
                }
            }
        }
    }
}