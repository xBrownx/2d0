package com.brownx.a2d0.groups.domain.repository

import com.brownx.a2d0.groups.data.local.GroupEntity
import com.brownx.a2d0.groups.domain.model.Group
import com.brownx.a2d0.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
interface GroupRepository {

    suspend fun upsertGroupsList(groupsList: List<Group>)

    suspend fun upsertGroupItem(group: Group)

    suspend fun getAllGroups() : Flow<Resource<List<Group>>>

    suspend fun insertGroup(groupEntity: GroupEntity)

    suspend fun deleteGroup(groupEntity: GroupEntity)

}