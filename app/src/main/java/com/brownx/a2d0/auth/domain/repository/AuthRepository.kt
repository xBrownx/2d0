package com.brownx.a2d0.auth.domain.repository

import com.brownx.a2d0.auth.util.AuthResult

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
interface AuthRepository {

    suspend fun register(
        username: String,
        mobile: String,
        password: String
    ): AuthResult<Unit>

    suspend fun login(
        username: String,
        password: String
    ): AuthResult<Unit>

    suspend fun authenticate(): AuthResult<Unit>

    suspend fun logout(): AuthResult<Unit>


}