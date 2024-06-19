package com.brownx.a2d0.main.domain.repository

import com.brownx.a2d0.main.data.remote.dto.GroupDto
import com.brownx.a2d0.main.domain.model.Friend
import com.brownx.a2d0.main.domain.model.Group
import com.brownx.a2d0.main.domain.model.RemoteUserData
import com.brownx.a2d0.main.domain.model.Task
import com.brownx.a2d0.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */
interface MainRepository {

    suspend fun getUserDataFromRemote() : Flow<Resource<Unit>>

    suspend fun getUserGroupsFromLocal() : Flow<Resource<List<Group>>>

    suspend fun getUserTasksFromLocal(): Flow<Resource<List<Task>>>

    suspend fun getUserFriendsFromLocal(): Flow<Resource<List<Friend>>>

    suspend fun upsertGroupItem(group: Group)

    suspend fun registerGroup(group: Group)

    suspend fun upsertTaskItemToRemote(task: Task) : Flow<Resource<RemoteUserData>>

    suspend fun clearAllDatabases()

}