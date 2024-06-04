package com.brownx.a2d0.friends.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.brownx.a2d0.groups.domain.model.GroupList

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@Entity(tableName = "user_table")
data class FriendEntity(
    var userName: String = "",
    var userGroups: GroupList
) {
    @PrimaryKey(autoGenerate = true)
    var userId: Int? = null
}