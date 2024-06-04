package com.brownx.a2d0.auth.data.remote.dto

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
data class AuthRequest(
    val username: String = "",
    val mobile: String = "",
    val password: String = "",
    val token: String = ""
)