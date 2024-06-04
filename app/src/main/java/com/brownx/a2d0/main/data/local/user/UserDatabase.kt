package com.brownx.a2d0.main.data.local.user

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.brownx.a2d0.main.data.local.Converters

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@TypeConverters(value = [Converters::class])
@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDAO
}