package com.brownx.a2d0.main.data.remote.dto

import com.brownx.a2d0.groups.domain.model.GroupList

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */
data class GroupsResponse(
    val status: Boolean,
    val groupsList: GroupList
)