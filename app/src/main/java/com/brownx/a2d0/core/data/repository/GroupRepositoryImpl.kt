package com.brownx.a2d0.core.data.repository

import com.brownx.a2d0.core.data.local.group.Group
import com.brownx.a2d0.core.data.local.group.GroupDAO
import com.brownx.a2d0.core.domain.repository.GroupRepository
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
class GroupRepositoryImpl @Inject constructor(
    private val groupDao: GroupDAO
) : GroupRepository{

    override suspend fun insertGroup(group: Group) = groupDao.insertGroup(group)

    override suspend fun deleteGroup(group: Group) = groupDao.deleteGroup(group)

}