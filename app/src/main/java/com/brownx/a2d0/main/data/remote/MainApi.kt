package com.brownx.a2d0.main.data.remote

import com.brownx.a2d0.main.data.remote.dto.GroupsResponse
import com.brownx.a2d0.main.data.remote.dto.TasksResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
/**
 * @author Andrew Brown
 * created on 4/06/2024
 */



interface MainApi {

    @GET("/task-query")
    suspend fun getTasks(
        @Query("username") username: String,
        @Query("token") token: String,
    ) : TasksResponse?

    @GET("/group-query")
    suspend fun getGroups(
        @Query("username") username: String,
        @Query("token") token: String,
    ) : GroupsResponse?


}