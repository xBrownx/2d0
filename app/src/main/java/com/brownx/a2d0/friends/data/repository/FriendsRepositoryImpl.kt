package com.brownx.a2d0.friends.data.repository

import com.brownx.a2d0.friends.data.local.FriendEntity
import com.brownx.a2d0.friends.data.local.FriendsDAO

import com.brownx.a2d0.friends.domain.repository.FriendsRepository
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
class FriendsRepositoryImpl @Inject constructor(
    private val friendsDAO: FriendsDAO
) : FriendsRepository {

    override suspend fun insertUser(friendEntity: FriendEntity) = friendsDAO.insertUser(friendEntity)

    override suspend fun deleteUser(friendEntity: FriendEntity) = friendsDAO.deleteUser(friendEntity)

}