package com.brownx.a2d0.main.domain.repository

import com.brownx.a2d0.friends.domain.model.UserList
import com.brownx.a2d0.groups.domain.model.Group
import com.brownx.a2d0.groups.domain.model.GroupList
import com.brownx.a2d0.tasks.domain.model.Task
import com.brownx.a2d0.tasks.domain.model.TaskList
import com.brownx.a2d0.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */
interface MainRepository {

    suspend fun getGroupsByUser(
        username: String
    ) : Flow<Resource<GroupList>>

    suspend fun getTasksByUser(
        username: String
    ) : Flow<Resource<TaskList>>

    suspend fun getFriendsByUser(
        username: String
    ) : Flow<Resource<UserList>>

    suspend fun upsertGroupsList(groupsList: GroupList)

    suspend fun upsertTasksList(tasksList: TaskList)

    suspend fun upsertFriendsList(friendsList: UserList)

    suspend fun upsertGroup(group: Group)

    suspend fun upsertTaskItem(task: Task)

    suspend fun clearAllDatabases()

}