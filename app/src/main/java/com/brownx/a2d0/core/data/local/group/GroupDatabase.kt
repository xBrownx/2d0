package com.brownx.a2d0.core.data.local.group

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.brownx.a2d0.core.data.local.Converters

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@TypeConverters(value = [Converters::class])
@Database(entities = [Group::class], version = 1)
abstract class GroupDatabase : RoomDatabase() {
    abstract fun getGroupDao(): GroupDAO
}