package com.brownx.a2d0.todo.domain.repository

import androidx.lifecycle.LiveData
import com.brownx.a2d0.todo.data.local.Task

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
interface TodoRepository {

    suspend fun insertTask(task: Task)

    suspend fun deleteTask(task: Task)

    fun getAssignedTaskSortedByDueDate(): LiveData<List<Task>>

    fun getTasksSortedByGroup(groupId: String): LiveData<List<Task>>

}