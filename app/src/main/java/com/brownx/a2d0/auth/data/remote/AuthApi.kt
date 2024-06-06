package com.brownx.a2d0.auth.data.remote
import com.brownx.a2d0.auth.data.remote.dto.AuthRequest
import com.brownx.a2d0.auth.data.remote.dto.AuthResponse
import com.brownx.a2d0.main.util.Const.AUTHENTICATE_ROUTE
import com.brownx.a2d0.main.util.Const.LOGIN_ROUTE
import com.brownx.a2d0.main.util.Const.LOGOUT_ROUTE
import com.brownx.a2d0.main.util.Const.REGISTER_ROUTE
import retrofit2.http.Body
import retrofit2.http.POST
/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
interface AuthApi {

    @POST(LOGIN_ROUTE)
    suspend fun login(
        @Body authRequest: AuthRequest
    ): AuthResponse

    @POST(AUTHENTICATE_ROUTE)
    suspend fun authenticate(
        @Body authRequest: AuthRequest
    ): AuthResponse

    @POST(LOGOUT_ROUTE)
    suspend fun logout(
        @Body authRequest: AuthRequest
    ): AuthResponse

    @POST(REGISTER_ROUTE)
    suspend fun register(
        @Body authRequest: AuthRequest
    ): AuthResponse

}