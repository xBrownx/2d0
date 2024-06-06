package com.brownx.a2d0.main.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
@Entity(tableName = "task_table")
data class TaskEntity(
    @PrimaryKey
    var taskId: String = "",
    var groupId: String = "",
    var createdTimeStamp: Long = 0L,
    var taskName: String = "",
    var taskDescription: String = "",
    var dueDate: Long = 0L,
    var isRecurring: Boolean = false,
    var isComplete: Boolean = false,
    var assignedBy: String = "",
    //var assignedTo: UserList? = null,
)
