package com.brownx.a2d0.main.data.remote.dto

import com.brownx.a2d0.groups.domain.model.Group

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */
data class GroupsResponse(
    val status: Boolean,
    val msg: String?,
    val token: String?,
    val data: List<Group>
)