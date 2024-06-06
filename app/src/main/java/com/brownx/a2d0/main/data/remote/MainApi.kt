package com.brownx.a2d0.main.data.remote

import com.brownx.a2d0.main.data.remote.dto.ServerQuery
import com.brownx.a2d0.main.data.remote.dto.ServerReponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */



interface MainApi {

    @POST("/user-group-query")
    suspend fun getGroupIdsForUser(
        @Body query: ServerQuery
    ) : ServerReponse?

    @POST("/group-task-query")
    suspend fun getTasksFromGroupIds(
        @Body query: ServerQuery
    ) : ServerReponse?

    @POST("/user-friends-query")
    suspend fun getFriendsForUser(
        @Body query: ServerQuery
    ) : ServerReponse?

    @POST("/register-group")
    suspend fun registerGroup(
        @Body query: ServerQuery
    ) : ServerReponse?

    @POST("/register-task")
    suspend fun registerTask(
        @Body query: ServerQuery
    ) : ServerReponse?



}