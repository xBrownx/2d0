package com.brownx.a2d0.groups.data.repository

import com.brownx.a2d0.groups.data.local.GroupEntity
import com.brownx.a2d0.groups.data.local.GroupDAO
import com.brownx.a2d0.groups.domain.repository.GroupRepository
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
class GroupRepositoryImpl @Inject constructor(
    private val groupDao: GroupDAO
) : GroupRepository {

    override suspend fun insertGroup(groupEntity: GroupEntity) = groupDao.insertGroup(groupEntity)

    override suspend fun deleteGroup(groupEntity: GroupEntity) = groupDao.deleteGroup(groupEntity)

}