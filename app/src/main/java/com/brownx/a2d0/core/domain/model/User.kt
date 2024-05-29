package com.brownx.a2d0.core.domain.model

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
data class User(
    val userId: String,
    val userName: String,
    val userGroups: GroupList,
    val userFriends: UserList,
)