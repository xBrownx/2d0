package com.brownx.a2d0.auth.presenter

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
data class AuthState(

    val screenTitle: String = "LOGIN",

    val isLoading: Boolean = false,

    val username: String = "",
    val password: String = ""
)
