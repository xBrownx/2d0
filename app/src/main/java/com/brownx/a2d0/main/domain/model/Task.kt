package com.brownx.a2d0.main.domain.model

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
data class Task(
    var taskId: String = "",
    var groupId: String = "",
    var createdTimeStamp: Long = 0L,
    var taskName: String = "",
    var taskDescription: String = "",
    var dueDate: Long = 0L,
    var isRecurring: Boolean = false,
    var isComplete: Boolean = false,
    var assignedBy: String = "",
    var assignedTo: List<Friend>? = null,
)