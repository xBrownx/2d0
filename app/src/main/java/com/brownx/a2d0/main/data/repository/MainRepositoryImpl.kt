package com.brownx.a2d0.main.data.repository

import android.app.Application
import android.content.SharedPreferences
import com.brownx.a2d0.friends.data.local.FriendsDAO
import com.brownx.a2d0.friends.domain.model.User
import com.brownx.a2d0.friends.domain.model.UserList
import com.brownx.a2d0.groups.data.local.GroupDAO
import com.brownx.a2d0.groups.data.mapper.toGroup
import com.brownx.a2d0.groups.data.mapper.toGroupEntity
import com.brownx.a2d0.groups.domain.model.Group
import com.brownx.a2d0.main.data.remote.MainApi
import com.brownx.a2d0.main.data.remote.dto.QueryGroupIdsForUser
import com.brownx.a2d0.main.data.remote.dto.RegisterGroup
import com.brownx.a2d0.main.domain.repository.MainRepository
import com.brownx.a2d0.tasks.data.local.TaskDAO
import com.brownx.a2d0.tasks.domain.model.Task
import com.brownx.a2d0.tasks.domain.model.TaskList
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
    private val groupDao: GroupDAO,
    private val taskDao: TaskDAO,
    private val friendsDAO: FriendsDAO
) : MainRepository {

    override suspend fun getGroupsByUser(): Flow<Resource<List<Group>>> {

        return flow {

            emit(Resource.Loading(true))

            val remoteGroups = try {
                mainApi.getGroupIdsForUser(
                    QueryGroupIdsForUser(
                        username = prefs.getString("username", null)!!,
                        token = prefs.getString("token", null)!!
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

            remoteGroups?.let { groups ->
                Timber.d("success, adding to local db")
                val entities = groups.map { it.toGroupEntity() }
                groupDao.upsertGroupList(entities)
                emit(Resource.Success(entities.map { it.toGroup() }))
                emit(Resource.Loading(false))
                return@flow
            }
        }
    }

    override suspend fun getTasksByUser(username: String): Flow<Resource<List<Task>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getFriendsByUser(username: String): Flow<Resource<List<User>>> {
        TODO("Not yet implemented")
    }

    override suspend fun registerGroup(group: Group) {
        Timber.d("registerGroup")
        try {
            mainApi.registerGroup(
                RegisterGroup(
                    prefs.getString("username", null)!!,
                    prefs.getString("token", null)!!,
                    group
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


    override suspend fun upsertTasksList(tasksList: TaskList) {
        TODO("Not yet implemented")
    }

    override suspend fun upsertFriendsList(friendsList: UserList) {
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