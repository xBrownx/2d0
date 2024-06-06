package com.brownx.a2d0.main.data.remote.dto

/**
 * @author Andrew Brown
 * created on 6/06/2024
 */
data class ServerReponse(
    val status: Boolean,
    val msg: String?,
    val token: String?,
    val data: List<Any>
)
