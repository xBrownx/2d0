package com.brownx.a2d0.main.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Entity(tableName = "group_table")
data class GroupEntity(

    @PrimaryKey
    var groupId: String = "",
    var groupName: String = "",
    var groupOwnerId: String = "",
    var createdTimestamp: Long = 0L,
)