package com.brownx.a2d0.main.util

import androidx.room.TypeConverter
import com.brownx.a2d0.main.domain.model.Friend
import com.brownx.a2d0.main.domain.model.Group
import com.brownx.a2d0.main.domain.model.Task
import com.google.gson.Gson

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
class TConverters {

    @TypeConverter
    fun groupListToJSON(groupList: List<Group>): String = Gson().toJson(groupList)

    @TypeConverter
    fun taskListToJSON(taskList: List<Task>) = Gson().toJson(taskList)

    @TypeConverter
    fun friendListToJSON(friendList: List<Friend>): String = Gson().toJson(friendList)

    @TypeConverter
    fun JSONToGroupList(json: String): List<Group> = Gson().fromJson(json, Array<Group>::class.java).toList()

    @TypeConverter
    fun JSONToTaskList(json: String): List<Task> = Gson().fromJson(json, Array<Task>::class.java).toList()

    @TypeConverter
    fun JSONToUserList(json: String): List<Friend> = Gson().fromJson(json, Array<Friend>::class.java).toList()

    @TypeConverter
    fun groupToJson(group: Group): String = Gson().toJson(group)







}