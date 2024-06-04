package com.brownx.a2d0.groups.presenter.groups

import com.brownx.a2d0.main.data.local.group.GroupEntity

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
data class GroupsState (

    val isLoading: Boolean = false,

    val groupsList: List<GroupEntity> = mutableListOf(),

    )