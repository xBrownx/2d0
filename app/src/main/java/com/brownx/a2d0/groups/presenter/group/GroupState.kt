package com.brownx.a2d0.groups.presenter.group

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
data class GroupState(
    val isLoading: Boolean = false,

    val groupName: String = "",
    val groupOwner: String = "",
    val numberOfTasks: String = "",
    val numberOfTasksAssignedToMe: String = "",
    val groupMembers: List<String> = listOf(),

)