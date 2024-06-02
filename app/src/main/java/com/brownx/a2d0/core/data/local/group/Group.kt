package com.brownx.a2d0.core.data.local.group

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.brownx.a2d0.core.domain.model.TaskList
import com.brownx.a2d0.core.domain.model.UserList

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Entity(tableName = "group_table")
data class Group(

    var groupName: String = "",
    var groupOwnerId: String = "",
    var createDate: String = "",
    var tasksInGroup: TaskList,

) {
    @PrimaryKey(autoGenerate = true)
    var groupId: Int? = null
}