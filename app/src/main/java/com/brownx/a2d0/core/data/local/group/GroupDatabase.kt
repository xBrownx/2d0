package com.brownx.a2d0.core.data.local.group

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Database(entities = [Group::class], version = 1)
abstract class GroupDatabase : RoomDatabase() {
    abstract fun getGroupDao(): GroupDAO
}