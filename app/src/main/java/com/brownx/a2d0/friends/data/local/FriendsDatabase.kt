package com.brownx.a2d0.friends.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.brownx.a2d0.util.TConverters


/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@TypeConverters(TConverters::class)
@Database(entities = [FriendEntity::class], version = 1)
abstract class FriendsDatabase : RoomDatabase() {
    abstract fun getFriendsDao(): FriendsDAO
}