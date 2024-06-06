package com.brownx.a2d0.main.domain.model

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
data class Friend(
    val userId: String,
    val userName: String,
    val friendsSinceTimestamp: Long,
    val userGroups: List<Group>? = null,
    val friendFriends: List<Friend>? = null,
)