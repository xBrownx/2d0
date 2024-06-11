package com.brownx.a2d0.auth.data.remote

import com.brownx.a2d0.auth.data.remote.dto.AuthRequest
import com.brownx.a2d0.auth.data.remote.dto.AuthResponse
import com.brownx.a2d0.main.data.remote.MainApi
import retrofit2.http.Body
import retrofit2.http.POST
/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
interface AuthApi {

    @POST(MainApi.LOGIN_ROUTE)
    suspend fun login(
        @Body authRequest: AuthRequest
    ): AuthResponse

    @POST(MainApi.AUTHENTICATE_ROUTE)
    suspend fun authenticate(
        @Body authRequest: AuthRequest
    ): AuthResponse

    @POST(MainApi.LOGOUT_ROUTE)
    suspend fun logout(
        @Body authRequest: AuthRequest
    ): AuthResponse

    @POST(MainApi.REGISTER_ROUTE)
    suspend fun register(
        @Body authRequest: AuthRequest
    ): AuthResponse

}