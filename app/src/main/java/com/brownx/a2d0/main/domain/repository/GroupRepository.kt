package com.brownx.a2d0.main.domain.repository

import com.brownx.a2d0.main.data.local.group.GroupEntity

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
interface GroupRepository {

    suspend fun insertGroup(groupEntity: GroupEntity)

    suspend fun deleteGroup(groupEntity: GroupEntity)

}