package com.brownx.a2d0.groups.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@TypeConverters(value = [TypeConverters::class])
@Database(entities = [GroupEntity::class], version = 1)
abstract class GroupDatabase : RoomDatabase() {
    abstract fun getGroupDao(): GroupDAO
}