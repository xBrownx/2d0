package com.brownx.a2d0.todo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
@Database(entities = [Task::class], version = 1)

abstract class TaskDatabase : RoomDatabase() {
    abstract fun getTaskDao(): TaskDAO
}