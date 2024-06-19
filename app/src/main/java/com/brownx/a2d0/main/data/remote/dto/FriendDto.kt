package com.brownx.a2d0.main.data.remote.dto

/**
 * @author Andrew Brown
 * created on 13/06/2024
 */
data class FriendDto (
    val user_id: String,
    val user_name: String,
    val friends_since_timestamp: Long,
    val user_groups: String? = null,
    val friend_friends: String? = null,
)