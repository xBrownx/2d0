package com.brownx.a2d0.main.data.remote

import com.brownx.a2d0.main.data.remote.dto.GroupsResponse
import com.brownx.a2d0.main.data.remote.dto.QueryGroupIdsForUser
import com.brownx.a2d0.main.data.remote.dto.RegisterGroup
import com.brownx.a2d0.main.data.remote.dto.RegisterResponse
import com.brownx.a2d0.main.data.remote.dto.TasksResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
/**
 * @author Andrew Brown
 * created on 4/06/2024
 */



interface MainApi {

    @POST("/register-group")
    suspend fun registerGroup(
        @Body registerGroup: RegisterGroup
    ) : RegisterResponse

    @POST("/user-group-query")
    suspend fun getGroupIdsForUser(
        @Body query: QueryGroupIdsForUser
    ) : GroupsResponse

    @GET("/task-query")
    suspend fun getTasks(
        @Query("username") username: String,
        @Query("token") token: String,
    ) : TasksResponse?



}