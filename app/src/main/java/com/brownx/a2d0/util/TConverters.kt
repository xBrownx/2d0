package com.brownx.a2d0.util

import androidx.room.TypeConverter
import com.brownx.a2d0.friends.domain.model.User
import com.brownx.a2d0.tasks.domain.model.TaskList
import com.brownx.a2d0.friends.domain.model.UserList
import com.brownx.a2d0.groups.domain.model.Group
import com.brownx.a2d0.tasks.domain.model.Task
import com.google.gson.Gson

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
class TConverters {

    @TypeConverter
    fun userListToJSON(userList: List<User>): String = Gson().toJson(userList)

    @TypeConverter
    fun JSONToUserList(json: String): UserList = Gson().fromJson(json, UserList::class.java)

    @TypeConverter
    fun groupListToJSON(groupList: List<Group>): String = Gson().toJson(groupList)

    @TypeConverter
    fun groupToJson(group: Group): String = Gson().toJson(group)

    @TypeConverter
    fun JSONToGroupList(json: String) = Gson().fromJson(json, Array<Group>::class.java).toList()

    @TypeConverter
    fun taskListToJSON(taskList: List<Task>) = Gson().toJson(taskList)

    @TypeConverter
    fun JSONToTaskList(json: String) = Gson().fromJson(json, TaskList::class.java)

}