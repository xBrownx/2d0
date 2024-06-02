package com.brownx.a2d0.auth.presenter

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
sealed class AuthUiEvents {

    data class OnUsernameChanged(
        val username: String
    ) : AuthUiEvents()

    data class OnPasswordChanged(
        val password: String
    ) : AuthUiEvents()

    data object Login : AuthUiEvents()

}