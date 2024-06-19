package com.brownx.a2d0.main.data.remote.dto

/**
 * @author Andrew Brown
 * created on 13/06/2024
 */
data class GroupDto(
    val group_id: String,
    val group_name: String,
    val group_owner: String,
    val created_timestamp: Long
)