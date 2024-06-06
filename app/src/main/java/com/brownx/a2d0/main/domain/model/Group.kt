package com.brownx.a2d0.main.domain.model

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
data class Group(
    var groupId: String = "",
    var groupName: String = "",
    var groupOwnerId: String = "",
    var createdDateTimestamp: Long = 0L,
)
