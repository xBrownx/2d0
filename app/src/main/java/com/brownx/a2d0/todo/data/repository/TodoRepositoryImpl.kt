package com.brownx.a2d0.todo.data.repository

import androidx.lifecycle.LiveData
import com.brownx.a2d0.todo.data.local.Task
import com.brownx.a2d0.todo.data.local.TaskDAO
import com.brownx.a2d0.todo.domain.repository.TodoRepository
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
class TodoRepositoryImpl @Inject constructor(
    private val taskDao: TaskDAO
) : TodoRepository {

    override suspend fun insertTask(task: Task) = taskDao.insertTask(task)

    override suspend fun deleteTask(task: Task) = taskDao.deleteTask(task)

    override fun getAssignedTaskSortedByDueDate() = taskDao.getAssignedTaskSortedByDueDate()

    override fun getTasksSortedByGroup(groupId: String) = taskDao.getTaskSortedByGroup(groupId)

}