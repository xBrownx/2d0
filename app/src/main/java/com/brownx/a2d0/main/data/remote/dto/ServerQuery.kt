package com.brownx.a2d0.main.data.remote.dto

import com.brownx.a2d0.main.domain.model.Group
import com.brownx.a2d0.main.domain.model.Task

/**
 * @author Andrew Brown
 * created on 6/06/2024
 */
data class ServerQuery(
    val username: String,
    val token: String,
    val deviceId: String? = null,
    val group: Group? = null,
    val groupIds: List<String>? = null,
    val task: Task? = null,
    )
