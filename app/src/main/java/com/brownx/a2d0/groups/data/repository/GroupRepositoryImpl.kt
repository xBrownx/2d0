package com.brownx.a2d0.groups.data.repository

import com.brownx.a2d0.groups.data.local.GroupEntity
import com.brownx.a2d0.groups.data.local.GroupDAO
import com.brownx.a2d0.groups.data.mapper.toGroup
import com.brownx.a2d0.groups.data.mapper.toGroupEntity
import com.brownx.a2d0.groups.domain.model.Group
import com.brownx.a2d0.groups.domain.repository.GroupRepository
import com.brownx.a2d0.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
class GroupRepositoryImpl @Inject constructor(
    private val groupDao: GroupDAO
) : GroupRepository {

    override suspend fun upsertGroupsList(groupsList: List<Group>) {
        groupDao.upsertGroupList(groupsList.map { it.toGroupEntity() })
    }

    override suspend fun upsertGroupItem(group: Group) {
        groupDao.upsertGroupItem(group.toGroupEntity())
    }

    override suspend fun getAllGroups(): Flow<Resource<List<Group>>> {
        Timber.d("getAllGroups() = ${groupDao.getAllGroups().map { it.toGroup() }}")

        return flow {
            emit(Resource.Loading(true))
            val localGroups = groupDao.getAllGroups().map { it.toGroup() }
            localGroups.let { groups ->
                Timber.d("success, getting groups from local db == $groups")
                emit(Resource.Success(groups))
                emit(Resource.Loading(false))
                return@flow
            }
        }
    }

    override suspend fun insertGroup(groupEntity: GroupEntity) = groupDao.insertGroup(groupEntity)

    override suspend fun deleteGroup(groupEntity: GroupEntity) = groupDao.deleteGroup(groupEntity)

}