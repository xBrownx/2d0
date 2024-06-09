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
    var isRepeat: Boolean = false,
    var repeatFrequency: Int = 0,
    var repeatFrequencyUnit: String = "",
    var isComplete: Boolean = false,
    var completeTimestamp: List<Long> = listOf(),
    var assignedBy: String = "",
    var assignedTo: List<Friend>? = null,
)