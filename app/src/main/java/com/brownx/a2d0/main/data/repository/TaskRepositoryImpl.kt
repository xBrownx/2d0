package com.brownx.a2d0.main.data.repository

import com.brownx.a2d0.main.data.local.task.TaskEntity
import com.brownx.a2d0.main.data.local.task.TaskDAO
import com.brownx.a2d0.main.domain.repository.TaskRepository
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