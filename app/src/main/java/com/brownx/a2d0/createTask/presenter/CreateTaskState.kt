package com.brownx.a2d0.createTask.presenter

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
data class CreateTaskState(
    val taskGroup: String = "",
    val taskName: String = "",
    val assignedTo: String = "",
    val taskDescription: String = "",
    val dueDate: String = "",
    val isRecurring: Boolean = false,
)
