package com.brownx.a2d0.groups.data.local

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
    var createDate: Long = 0L,
)