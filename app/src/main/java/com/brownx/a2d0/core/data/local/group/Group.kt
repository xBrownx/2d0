package com.brownx.a2d0.core.data.local.group

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Entity(tableName = "group_table")
data class Group(
    var groupName: String = "",
) {
    @PrimaryKey(autoGenerate = true)
    var groupId: Int? = null
}