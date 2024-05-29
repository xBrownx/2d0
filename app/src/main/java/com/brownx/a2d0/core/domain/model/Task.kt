package com.brownx.a2d0.core.domain.model

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
data class Task(
    var taskId: String,
    var groupId: String,
    var createdTimeStamp: Long,
    var taskName: String,
    var taskDescription: String,
    var dueDate: Long,
    var isRecurring: Boolean,
    var isComplete: Boolean,
    var assignedBy: String,
    var assignedTo: UserList,
)