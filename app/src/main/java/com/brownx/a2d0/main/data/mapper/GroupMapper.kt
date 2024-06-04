package com.brownx.a2d0.main.data.mapper

import com.brownx.a2d0.main.data.local.group.GroupEntity
import com.brownx.a2d0.main.domain.model.Group

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */

fun GroupEntity.toGroup(): Group {
    return Group(
        groupId = groupId,
        groupName = groupName,
        groupOwnerId = groupOwnerId,
        createDate = createDate,
    )
}

fun Group.toGroupEntity(): GroupEntity {
    return GroupEntity(
        groupId = groupId,
        groupName = groupName,
        groupOwnerId = groupOwnerId,
        createDate = createDate,
    )
}
