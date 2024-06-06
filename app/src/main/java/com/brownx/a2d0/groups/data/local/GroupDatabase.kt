package com.brownx.a2d0.groups.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.brownx.a2d0.util.TConverters

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@TypeConverters(TConverters::class)
@Database(entities = [GroupEntity::class], version = 1)
abstract class GroupDatabase : RoomDatabase() {
    abstract fun getGroupDao(): GroupDAO
}