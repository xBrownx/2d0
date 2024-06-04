package com.brownx.a2d0.main.data.local.group

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.brownx.a2d0.main.domain.model.TaskList

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