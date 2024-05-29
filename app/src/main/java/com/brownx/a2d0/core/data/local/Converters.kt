package com.brownx.a2d0.core.data.local

import androidx.room.TypeConverter
import com.brownx.a2d0.core.domain.model.GroupList
import com.brownx.a2d0.core.domain.model.TaskList
import com.brownx.a2d0.core.domain.model.UserList
import com.google.gson.Gson

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
class Converters {

    @TypeConverter
    fun userListToJSON(userList: UserList) = Gson().toJson(userList)

    @TypeConverter
    fun JSONToUserList(json: String) = Gson().fromJson(json, UserList::class.java)

    @TypeConverter
    fun groupListToJSON(groupList: GroupList) = Gson().toJson(groupList)

    @TypeConverter
    fun JSONToGroupList(json: String) = Gson().fromJson(json, GroupList::class.java)

    @TypeConverter
    fun taskListToJSON(taskList: TaskList) = Gson().toJson(taskList)

    @TypeConverter
    fun JSONToTaskList(json: String) = Gson().fromJson(json, TaskList::class.java)

}