package com.brownx.a2d0.todo.data.local

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
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM task_table ORDER BY dueDate DESC")
    fun getAssignedTaskSortedByDueDate(): LiveData<List<Task>>

    @Query("SELECT * FROM task_table WHERE taskGroupId = :groupId ORDER BY dueDate DESC")
    fun getTaskSortedByGroup(groupId: String): LiveData<List<Task>>
}