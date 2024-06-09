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
    var isRepeat: Boolean = false,
    var repeatFrequency: Int = 0,
    var repeatFrequencyUnit: String = "",
    var isComplete: Boolean = false,
    var completeTimestamp: List<Long> = listOf(),
    var assignedBy: String = "",
    //var assignedTo: UserList? = null,
)
