package com.brownx.a2d0.main.data.remote.dto

/**
 * @author Andrew Brown
 * created on 13/06/2024
 */
data class TaskDto (
    val task_id: String = "",
    val group_id: String = "",
    val created_timestamp: Long = 0L,
    val task_name: String = "",
    val task_description: String = "",
    val due_date: Long = 0L,
    val is_repeat: Boolean = false,
    val repeat_frequency: Int? = null,
    val repeat_frequency_unit: String? = null,
    val is_complete: Boolean? = null,
    val completed_timestamps: List<Long>? = null,
    val assigned_by: String,
    val assigned_to: String? = "",
)