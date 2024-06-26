package com.brownx.a2d0.main.data.mappers

import com.brownx.a2d0.main.data.local.entity.FriendEntity
import com.brownx.a2d0.main.data.remote.dto.FriendDto
import com.brownx.a2d0.main.domain.model.Friend

/**
 * @author Andrew Brown
 * created on 6/06/2024
 */

fun FriendEntity.toFriend() : Friend {
    return Friend(
        userId = userId,
        userName = userName,
        friendsSinceTimestamp = friendsSinceTimestamp,
    )
}

fun Friend.toFriendEntity() : FriendEntity {
    return FriendEntity(
        userId = userId,
        userName = userName,
        friendsSinceTimestamp = friendsSinceTimestamp
    )
}

fun FriendDto.toFriendEntity() : FriendEntity {
    return FriendEntity(
        userId = user_id,
        userName = user_name,
        friendsSinceTimestamp = friends_since_timestamp
    )
}