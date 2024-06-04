package com.brownx.a2d0.friends.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@Dao
interface FriendsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(friendEntity: FriendEntity)

    @Delete
    suspend fun deleteUser(friendEntity: FriendEntity)
}