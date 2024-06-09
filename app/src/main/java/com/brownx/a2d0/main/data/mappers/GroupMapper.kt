package com.brownx.a2d0.main.data.mappers

import com.brownx.a2d0.main.data.local.entity.GroupEntity
import com.brownx.a2d0.main.domain.model.Group
import com.google.gson.Gson

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */

fun GroupEntity.toGroup(): Group {
    return Group(
        groupId = groupId,
        groupName = groupName,
        groupOwnerId = groupOwnerId,
        createdTimestamp = createdTimestamp,
    )
}

fun Group.toGroupEntity(): GroupEntity {
    return GroupEntity(
        groupId = groupId,
        groupName = groupName,
        groupOwnerId = groupOwnerId,
        createdTimestamp = createdTimestamp,
    )
}


