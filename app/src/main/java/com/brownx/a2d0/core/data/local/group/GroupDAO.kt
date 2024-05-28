package com.brownx.a2d0.core.data.local.group

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
@Dao
interface GroupDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroup(group: Group)

    @Delete
    suspend fun deleteGroup(group: Group)
}
