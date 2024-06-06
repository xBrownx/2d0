package com.brownx.a2d0.main.data.mappers

import com.brownx.a2d0.main.data.local.entity.TaskEntity
import com.brownx.a2d0.main.domain.model.Task

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */

fun TaskEntity.toTask(): Task {
    return Task(
        taskId = taskId,
        groupId = groupId,
        createdTimeStamp = createdTimeStamp,
        taskName = taskName,
        taskDescription = taskDescription,
        dueDate = dueDate,
        isRecurring = isRecurring,
        isComplete = isComplete,
        assignedBy = assignedBy,
        //assignedTo = assignedTo
    )
}

fun Task.toTaskEntity(): TaskEntity {
    return TaskEntity(
        taskId = taskId,
        groupId = groupId,
        createdTimeStamp = createdTimeStamp,
        taskName = taskName,
        taskDescription = taskDescription,
        dueDate = dueDate,
        isRecurring = isRecurring,
        isComplete = isComplete,
        assignedBy = assignedBy,
        //assignedTo = assignedTo
    )
}