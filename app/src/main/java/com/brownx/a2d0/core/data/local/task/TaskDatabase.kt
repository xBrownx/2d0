package com.brownx.a2d0.core.data.local.task

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.brownx.a2d0.core.data.local.Converters

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
@TypeConverters(value = [Converters::class])
@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun getTaskDao(): TaskDAO
}