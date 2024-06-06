package com.brownx.a2d0.friends.domain.model

import com.brownx.a2d0.groups.domain.model.Group

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
data class User(
    val userId: String,
    val userName: String,
    val userGroups: List<Group>,
    val userFriends: List<User>,
)