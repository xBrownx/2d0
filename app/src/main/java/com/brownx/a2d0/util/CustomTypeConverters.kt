package com.brownx.a2d0.util

import androidx.room.TypeConverter
import com.brownx.a2d0.groups.domain.model.GroupList
import com.brownx.a2d0.tasks.domain.model.TaskList
import com.brownx.a2d0.friends.domain.model.UserList
import com.google.gson.Gson

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
class CustomTypeConverters {

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