package com.brownx.a2d0.auth.data.remote.dto

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
data class AuthResponse(
    val status: Boolean,
    val code: Int?,
    val username: String?,
    val token: String?,
    val msg: String?,
)