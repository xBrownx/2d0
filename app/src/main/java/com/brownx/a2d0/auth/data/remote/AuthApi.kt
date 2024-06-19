package com.brownx.a2d0.auth.data.remote

import com.brownx.a2d0.auth.data.remote.dto.AuthResponse
import com.brownx.a2d0.main.data.remote.MainApi
import com.brownx.a2d0.main.data.remote.dto.ServerQuery
import com.brownx.a2d0.main.data.remote.dto.ServerResponse
import retrofit2.http.Body
import retrofit2.http.POST
/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
interface AuthApi {

    @POST(MainApi.LOGIN_ROUTE)
    suspend fun login(
        @Body request: ServerQuery
    ): ServerResponse?

    @POST(MainApi.AUTHENTICATE_ROUTE)
    suspend fun authenticate(
        @Body request: ServerQuery
    ): ServerResponse?

    @POST(MainApi.LOGOUT_ROUTE)
    suspend fun logout(
        @Body request: ServerQuery
    ): ServerResponse?

    @POST(MainApi.REGISTER_ROUTE)
    suspend fun register(
        @Body request: ServerQuery
    ): ServerResponse?

}