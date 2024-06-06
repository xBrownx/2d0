package com.brownx.a2d0.main.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.brownx.a2d0.main.data.local.dao.FriendDAO
import com.brownx.a2d0.main.data.local.dao.GroupDAO
import com.brownx.a2d0.main.data.local.dao.TaskDAO
import com.brownx.a2d0.main.data.local.entity.FriendEntity
import com.brownx.a2d0.main.data.local.entity.GroupEntity
import com.brownx.a2d0.main.data.local.entity.TaskEntity
import com.brownx.a2d0.main.util.TConverters

/**
 * @author Andrew Brown
 * created on 6/06/2024
 */
@TypeConverters(TConverters::class)
@Database(
    entities = [GroupEntity::class, TaskEntity::class, FriendEntity::class],
    version = 1
)
abstract class MainDatabase : RoomDatabase() {
    abstract fun getGroupDao(): GroupDAO
    abstract fun getTaskDao(): TaskDAO
    abstract fun getFriendDao(): FriendDAO
}