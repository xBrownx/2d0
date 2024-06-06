package com.brownx.a2d0.main.data.remote.dto

import com.brownx.a2d0.groups.domain.model.Group

/**
 * @author Andrew Brown
 * created on 5/06/2024
 */
data class RegisterGroup (
    val username: String,
    val token: String,
    val group: Group
)