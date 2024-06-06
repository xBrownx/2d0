package com.brownx.a2d0.groups.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Dao
interface GroupDAO {

    @Upsert
    suspend fun upsertGroupList(groupEntities: List<GroupEntity>)

    @Upsert
    suspend fun upsertGroupItem(groupEntity: GroupEntity)

    @Query("SELECT * FROM group_table ORDER BY createdDateTimestamp ASC")
    suspend fun getAllGroups(): List<GroupEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroup(groupEntity: GroupEntity)

    @Delete
    suspend fun deleteGroup(groupEntity: GroupEntity)


}
