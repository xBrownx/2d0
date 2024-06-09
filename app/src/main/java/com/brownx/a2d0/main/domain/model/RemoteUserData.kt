package com.brownx.a2d0.main.domain.model

/**
 * @author Andrew Brown
 * created on 7/06/2024
 */
data class RemoteUserData(
    val groups: List<Group>,
    val tasks: List<Task>,
    val friends: List<Friend>
)
