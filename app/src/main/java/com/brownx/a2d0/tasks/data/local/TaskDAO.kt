package com.brownx.a2d0.tasks.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
@Dao
interface TaskDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(taskEntity: TaskEntity)

    @Delete
    suspend fun deleteTask(taskEntity: TaskEntity)

    @Query("SELECT * FROM task_table ORDER BY dueDate DESC")
    fun getAssignedTaskSortedByDueDate(): LiveData<List<TaskEntity>>

    @Query("SELECT * FROM task_table WHERE groupId = :groupId ORDER BY dueDate DESC")
    fun getTaskSortedByGroup(groupId: String): LiveData<List<TaskEntity>>

}