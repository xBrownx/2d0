package com.brownx.a2d0.groups.domain.repository

import com.brownx.a2d0.groups.data.local.GroupEntity

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
interface GroupRepository {

    suspend fun insertGroup(groupEntity: GroupEntity)

    suspend fun deleteGroup(groupEntity: GroupEntity)

}