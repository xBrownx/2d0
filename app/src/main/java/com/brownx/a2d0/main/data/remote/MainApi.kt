package com.brownx.a2d0.main.data.remote

import com.brownx.a2d0.main.data.remote.dto.ServerQuery
import com.brownx.a2d0.main.data.remote.dto.ServerResponse
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */

interface MainApi {

    @POST("/get-user-data")
    suspend fun getUserData(
        @Body query: ServerQuery
    ) : ServerResponse?

    @POST("/register-group")
    suspend fun registerGroup(
        @Body query: ServerQuery
    ) : ServerResponse?

    @POST("/register-task")
    suspend fun registerTask(
        @Body query: ServerQuery
    ) : ServerResponse?

    @POST("register-friend")
    suspend fun registerFriend(
        @Body query: ServerQuery
    ) : ServerResponse?

    companion object {
        const val SERVER_IP = "http://192.168.0.2:5000/"
        const val LOGIN_ROUTE = "/authenticate-login"
        const val AUTHENTICATE_ROUTE = "/authenticate-token"
        const val LOGOUT_ROUTE = "/logout-user"
        const val REGISTER_ROUTE = "/register-user"
    }
}