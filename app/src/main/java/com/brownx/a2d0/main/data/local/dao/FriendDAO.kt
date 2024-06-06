package com.brownx.a2d0.main.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.brownx.a2d0.main.data.local.entity.FriendEntity

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@Dao
interface FriendDAO {

    @Upsert
    suspend fun upsertFriendsList(friendEntities: List<FriendEntity>)

    @Upsert
    suspend fun upsertFriendItem(friendEntity: FriendEntity)

    @Query("SELECT * FROM friend_table ORDER BY friendsSinceTimestamp ASC")
    suspend fun getAllFriends() : List<FriendEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(friendEntity: FriendEntity)

    @Delete
    suspend fun deleteUser(friendEntity: FriendEntity)
}