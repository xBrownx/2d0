package com.brownx.a2d0.main.data.local.group

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy


/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Dao
interface GroupDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroup(groupEntity: GroupEntity)

    @Delete
    suspend fun deleteGroup(groupEntity: GroupEntity)
}
