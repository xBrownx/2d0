package com.brownx.a2d0.main.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.brownx.a2d0.main.data.local.entity.TaskEntity

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
@Dao
interface TaskDAO {

    @Upsert
    suspend fun upsertTaskList(taskEntityList: List<TaskEntity>)

    @Upsert
    suspend fun upsertTaskItem(taskEntity: TaskEntity)

    @Query("SELECT * FROM task_table ORDER BY dueDate DESC")
    fun getAllTasks(): List<TaskEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(taskEntity: TaskEntity)

    @Delete
    suspend fun deleteTask(taskEntity: TaskEntity)



    @Query("SELECT * FROM task_table WHERE groupId = :groupId ORDER BY dueDate DESC")
    fun getTaskSortedByGroup(groupId: String): LiveData<List<TaskEntity>>

}