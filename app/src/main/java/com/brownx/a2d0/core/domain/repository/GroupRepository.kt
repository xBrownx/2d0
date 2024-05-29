package com.brownx.a2d0.core.domain.repository

import com.brownx.a2d0.core.data.local.group.Group

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
interface GroupRepository {

    suspend fun insertGroup(group: Group)

    suspend fun deleteGroup(group: Group)

}