package com.brownx.a2d0.friends.domain.repository

import com.brownx.a2d0.friends.data.local.FriendEntity


/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
interface FriendsRepository {

    suspend fun insertUser(friendEntity: FriendEntity)

    suspend fun deleteUser(friendEntity: FriendEntity)

}