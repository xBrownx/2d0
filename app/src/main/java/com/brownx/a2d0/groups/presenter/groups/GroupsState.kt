package com.brownx.a2d0.groups.presenter.groups

import com.brownx.a2d0.groups.data.local.GroupEntity
import com.brownx.a2d0.groups.domain.model.Group
import com.brownx.a2d0.groups.util.GroupSortType

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
data class GroupsState (

    val isLoading: Boolean = false,

    val sortType: GroupSortType = GroupSortType.DATE,

    val groupsList: List<Group> = mutableListOf(),

    )