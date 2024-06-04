package com.brownx.a2d0.main.data.repository

import android.app.Application
import android.content.SharedPreferences
import com.brownx.a2d0.friends.domain.model.UserList
import com.brownx.a2d0.groups.data.local.GroupDAO
import com.brownx.a2d0.groups.data.mapper.toGroupEntity
import com.brownx.a2d0.groups.domain.model.Group
import com.brownx.a2d0.groups.domain.model.GroupList
import com.brownx.a2d0.main.data.remote.MainApi
import com.brownx.a2d0.main.domain.repository.MainRepository
import com.brownx.a2d0.tasks.data.local.TaskDAO
import com.brownx.a2d0.tasks.domain.model.Task
import com.brownx.a2d0.tasks.domain.model.TaskList
import com.brownx.a2d0.util.Resource
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

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
) : MainRepository {
    override suspend fun getGroupsByUser(username: String): Flow<Resource<GroupList>> {

        return flow {

            val remoteGroups = try {
                mainApi.getGroups(
                    username = prefs.getString("username", null)!!,
                    token = prefs.getString("token", null)!!
                )?.groupsList
            } catch (e: IOException) {
                e.printStackTrace()
                //emit(Resource.Error(application.getString(R.string.couldn_t_load_data)))
                //emit(Resource.Loading(false))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                //emit(Resource.Error(application.getString(R.string.couldn_t_load_data)))
                //emit(Resource.Loading(false))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                //emit(Resource.Error(application.getString(R.string.couldn_t_load_data)))
                //emit(Resource.Loading(false))
                return@flow
            }

            remoteGroups?.let { groupsResponse ->
                val entities = groupsResponse.groupList.map { groupsDto ->

                    val favoriteMedia =
                        favoritesRepository.getMediaItemById(
                            mediaDto.id ?: 0
                        )

                    groupsDto.toGroupEntity(
                        type = mediaDto.media_type ?: MOVIE,
                        category = TRENDING,
                        isLiked = favoriteMedia?.isLiked ?: false,
                        isBookmarked = favoriteMedia?.isBookmarked ?: false,
                    )
                }

                groupDao.upsertMediaList(entities)

                //emit(Resource.Success(entities.map { it.toMedia() }))
                //emit(Resource.Loading(false))//
                return@flow
            }
        }
    }

    override suspend fun getTasksByUser(username: String): Flow<Resource<TaskList>> {
        TODO("Not yet implemented")
    }

    override suspend fun getFriendsByUser(username: String): Flow<Resource<UserList>> {
        TODO("Not yet implemented")
    }

    override suspend fun upsertGroupsList(groupsList: GroupList) {
        TODO("Not yet implemented")
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