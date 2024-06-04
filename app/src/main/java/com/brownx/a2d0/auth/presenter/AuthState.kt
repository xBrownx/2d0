package com.brownx.a2d0.auth.presenter

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
data class AuthState(

    val isLoading: Boolean = false,

    val username: String = "",
    val mobile: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)
