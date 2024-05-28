package com.brownx.a2d0.core.data.local.task

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
@Entity(tableName = "task_table")
data class Task(
    var taskGroupId: String = "",
    var createdTimeStamp: Long = 0L,
    var taskName: String = "",
    var taskDescription: String = "",
    var dueDate: Long = 0L,
    var isRecurring: Boolean = false,
    var isComplete: Boolean = false,
    var assignedBy: String = "",
    var assignedTo: String = "",
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
