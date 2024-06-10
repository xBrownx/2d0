package com.brownx.a2d0.main.data.repository

import android.app.Application
import android.content.SharedPreferences
import com.brownx.a2d0.main.domain.model.Friend
import com.brownx.a2d0.main.data.mappers.toGroup
import com.brownx.a2d0.main.data.mappers.toGroupEntity
import com.brownx.a2d0.main.domain.model.Group
import com.brownx.a2d0.main.data.local.MainDatabase
import com.brownx.a2d0.main.data.mappers.toFriend
import com.brownx.a2d0.main.data.mappers.toFriendEntity
import com.brownx.a2d0.main.data.remote.MainApi
import com.brownx.a2d0.main.data.remote.dto.ServerQuery
import com.brownx.a2d0.main.domain.repository.MainRepository
import com.brownx.a2d0.main.data.mappers.toTask
import com.brownx.a2d0.main.data.mappers.toTaskEntity
import com.brownx.a2d0.main.domain.model.RemoteUserData
import com.brownx.a2d0.main.domain.model.Task
import com.brownx.a2d0.util.Resource
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */

class MainRepositoryImpl @Inject constructor(
    private val application: Application,
    private val mainApi: MainApi,
    private val prefs: SharedPreferences,
    private val mainDatabase: MainDatabase,
) : MainRepository {

    override suspend fun getUserDataFromRemote(): Flow<Resource<RemoteUserData>> {
        return flow {
            emit(Resource.Loading(true))

            val remoteData =
                try {
                    mainApi.getUserData(
                        ServerQuery(
                            username = prefs.getString("username", null)!!,
                            token = prefs.getString("token", null)!!,
                            deviceId = prefs.getString("device_id", null)!!,
                        )
                    )?.data
                } catch (e: IOException) {
                    e.printStackTrace()
                    emit(Resource.Error("Couldn't load data"))
                    emit(Resource.Loading(false))
                    return@flow
                } catch (e: HttpException) {
                    e.printStackTrace()
                    emit(Resource.Error("Couldn't load data"))
                    emit(Resource.Loading(false))
                    return@flow
                } catch (e: Exception) {
                    e.printStackTrace()
                    emit(Resource.Error("Couldn't load data"))
                    emit(Resource.Loading(false))
                    return@flow
                }
            remoteData?.let { data ->

                data.groups.let { groups ->
                    mainDatabase.getGroupDao().upsertGroupList(
                        groups.map { it.toGroupEntity() }
                    )
                }
                data.tasks.let { tasks ->
                    mainDatabase.getTaskDao().upsertTaskList(
                        tasks.map { it.toTaskEntity() }
                    )
                }
                data.friends.let { friends ->
                    mainDatabase.getFriendDao().upsertFriendsList(
                        friends.map { it.toFriendEntity() }
                    )
                }

                emit(Resource.Loading(false))
                emit(Resource.Success(remoteData))
                return@flow
            }
        }
    }

    override suspend fun getUserGroupsFromLocal(): Flow<Resource<List<Group>>> {
        return flow {
            emit(Resource.Loading(true))
            val localGroups = mainDatabase
                .getGroupDao()
                .getAllGroups().map { it.toGroup() }

            localGroups.let { groups ->
                emit(Resource.Success(groups))
                emit(Resource.Loading(false))
                return@flow
            }
        }
    }

    override suspend fun getUserTasksFromLocal(): Flow<Resource<List<Task>>> {
        return flow {
            emit(Resource.Loading(true))
            val localTasks = mainDatabase
                .getTaskDao()
                .getAllTasks().map { it.toTask() }

            localTasks.let { tasks ->
                emit(Resource.Success(tasks))
                emit(Resource.Loading(false))
                return@flow
            }
        }
    }

    override suspend fun getUserFriendsFromLocal(): Flow<Resource<List<Friend>>> {
        return flow {
            emit(Resource.Loading(true))
            val localTasks = mainDatabase
                .getFriendDao()
                .getAllFriends().map { it.toFriend() }

            localTasks.let { tasks ->
                emit(Resource.Success(tasks))
                emit(Resource.Loading(false))
                return@flow
            }
        }
    }


    override suspend fun upsertGroupsList(groupsList: List<Group>) {
        mainDatabase
            .getGroupDao()
            .upsertGroupList(
                groupsList.map { it.toGroupEntity() }
            )
    }

    override suspend fun upsertGroupItem(group: Group) {
        mainDatabase
            .getGroupDao()
            .upsertGroupItem(group.toGroupEntity())
    }

    override suspend fun registerGroup(group: Group) {
        try {
            mainApi.registerGroup(
                ServerQuery(
                    username = prefs.getString("username", null)!!,
                    token = prefs.getString("token", null)!!,
                    group = group
                )
            )
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: HttpException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    override suspend fun upsertTasksList(tasksList: List<Task>) {
        TODO("Not yet implemented")
    }

    override suspend fun upsertFriendsList(friendsList: List<Friend>) {
        TODO("Not yet implemented")
    }

    override suspend fun upsertGroup(group: Group) {
        TODO("Not yet implemented")
    }

    override suspend fun upsertTaskItem(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun clearAllDatabases() {
        TODO("Not yet implemented")
    }


}