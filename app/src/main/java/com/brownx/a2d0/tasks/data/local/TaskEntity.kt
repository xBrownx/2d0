package com.brownx.a2d0.tasks.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.brownx.a2d0.friends.domain.model.UserList

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
