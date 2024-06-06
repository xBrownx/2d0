package com.brownx.a2d0.main.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@Entity(tableName = "friend_table")
data class FriendEntity(

    @PrimaryKey
    var userId: String,
    var userName: String = "",
    var friendsSinceTimestamp: Long = 0L

)