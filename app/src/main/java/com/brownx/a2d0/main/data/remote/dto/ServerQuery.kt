package com.brownx.a2d0.main.data.remote.dto

import com.brownx.a2d0.main.domain.model.Friend
import com.brownx.a2d0.main.domain.model.Group
import com.brownx.a2d0.main.domain.model.Task

/**
 * @author Andrew Brown
 * created on 6/06/2024
 */
data class ServerQuery(
    val username: String,
    val deviceId: String? = null,
    val mobile: String? = null,
    val password: String? = null,
    val token: String? = null,
    val group: Group? = null,
    val task: Task? = null,
    val friend: Friend? = null
)
