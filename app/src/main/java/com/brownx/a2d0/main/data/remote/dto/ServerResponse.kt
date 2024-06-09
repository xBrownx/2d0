package com.brownx.a2d0.main.data.remote.dto

import com.brownx.a2d0.main.domain.model.RemoteUserData

/**
 * @author Andrew Brown
 * created on 6/06/2024
 */
data class ServerResponse(
    val status: Boolean,
    val msg: String?,
    val token: String?,
    val data: RemoteUserData?
)
