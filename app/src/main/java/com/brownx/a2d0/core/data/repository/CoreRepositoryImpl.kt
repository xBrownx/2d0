package com.brownx.a2d0.core.data.repository

import com.brownx.a2d0.core.data.local.task.Task
import com.brownx.a2d0.core.data.local.task.TaskDAO
import com.brownx.a2d0.core.domain.repository.CoreRepository
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
class CoreRepositoryImpl @Inject constructor(
    private val taskDao: TaskDAO,
) : CoreRepository {

    override suspend fun insertTask(task: Task) = taskDao.insertTask(task)

    override suspend fun deleteTask(task: Task) = taskDao.deleteTask(task)

    override fun getAssignedTaskSortedByDueDate() = taskDao.getAssignedTaskSortedByDueDate()

    override fun getTasksSortedByGroup(groupId: String) = taskDao.getTaskSortedByGroup(groupId)
}