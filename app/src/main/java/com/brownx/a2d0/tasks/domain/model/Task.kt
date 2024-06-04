package com.brownx.a2d0.tasks.domain.model

import com.brownx.a2d0.friends.domain.model.UserList

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
    var assignedTo: UserList? = null,
)