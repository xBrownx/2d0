package com.brownx.a2d0.tasks.domain.repository

import com.brownx.a2d0.tasks.data.local.TaskEntity
import com.brownx.a2d0.tasks.data.local.TaskDAO
import com.brownx.a2d0.tasks.data.repository.TaskRepository
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
class TaskRepositoryImpl @Inject constructor(
    private val taskDao: TaskDAO,
) : TaskRepository {

    override suspend fun insertTask(taskEntity: TaskEntity) = taskDao.insertTask(taskEntity)

    override suspend fun deleteTask(taskEntity: TaskEntity) = taskDao.deleteTask(taskEntity)

    override fun getAssignedTaskSortedByDueDate() = taskDao.getAssignedTaskSortedByDueDate()

    override fun getTasksSortedByGroup(groupId: String) = taskDao.getTaskSortedByGroup(groupId)
}