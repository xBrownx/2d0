package com.brownx.a2d0.main.domain.repository

import androidx.lifecycle.LiveData
import com.brownx.a2d0.main.data.local.task.TaskEntity

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
interface TaskRepository {

    suspend fun insertTask(taskEntity: TaskEntity)

    suspend fun deleteTask(taskEntity: TaskEntity)

    fun getAssignedTaskSortedByDueDate(): LiveData<List<TaskEntity>>

    fun getTasksSortedByGroup(groupId: String): LiveData<List<TaskEntity>>
}