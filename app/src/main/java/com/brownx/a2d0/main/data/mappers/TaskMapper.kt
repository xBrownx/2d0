package com.brownx.a2d0.main.data.mappers

import com.brownx.a2d0.main.data.local.entity.TaskEntity
import com.brownx.a2d0.main.data.remote.dto.TaskDto
import com.brownx.a2d0.main.domain.model.Task

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */

fun TaskEntity.toTask() : Task {
    return Task(
        taskId = taskId,
        groupId = groupId,
        createdTimeStamp = createdTimeStamp,
        taskName = taskName,
        taskDescription = taskDescription,
        dueDate = dueDate,
        isRepeat = isRepeat,
        repeatFrequency = repeatFrequency,
        repeatFrequencyUnit = repeatFrequencyUnit,
        completeTimestamp = completeTimestamp,
        isComplete = isComplete,
        assignedBy = assignedBy,
        //assignedTo = assignedTo
    )
}

fun Task.toTaskEntity() : TaskEntity {
    return TaskEntity(
        taskId = taskId,
        groupId = groupId,
        createdTimeStamp = createdTimeStamp,
        taskName = taskName,
        taskDescription = taskDescription,
        dueDate = dueDate,
        isRepeat = isRepeat,
        repeatFrequency = repeatFrequency,
        repeatFrequencyUnit = repeatFrequencyUnit,
        completeTimestamp = completeTimestamp,
        isComplete = isComplete,
        assignedBy = assignedBy,
        //assignedTo = assignedTo
    )
}

fun TaskDto.toTaskEntity(): TaskEntity {
    return TaskEntity(
        taskId = task_id,
        groupId = group_id,
        createdTimeStamp = created_timestamp,
        taskName = task_name,
        taskDescription = task_description,
        dueDate = due_date,
        isRepeat = is_repeat,
        repeatFrequency = repeat_frequency ?: -1,
        repeatFrequencyUnit = repeat_frequency_unit ?: "days",
        completeTimestamp = completed_timestamps ?: listOf(),
        isComplete = is_complete ?: false,
        assignedBy = assigned_by,

    )
}