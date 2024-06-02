package com.brownx.a2d0.auth.data.remote
import com.brownx.a2d0.auth.data.remote.dto.AuthRequest
import com.brownx.a2d0.auth.data.remote.dto.AuthResponse
import com.brownx.a2d0.util.Const.AUTHENTICATE_ROUTE
import com.brownx.a2d0.util.Const.LOGIN_ROUTE
import com.brownx.a2d0.util.Const.REGISTER_ROUTE
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
interface AuthApi {

    @POST(REGISTER_ROUTE)
    suspend fun register(
        @Body authRequest: AuthRequest
    ): AuthResponse

    @POST(LOGIN_ROUTE)
    suspend fun login(
        @Body authRequest: AuthRequest
    ): AuthResponse

    @GET(AUTHENTICATE_ROUTE)
    suspend fun authenticate(
        @Body authRequest: AuthRequest
    ): AuthResponse
}