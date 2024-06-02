package com.brownx.a2d0.util

/**
 * @author Andrew Brown
 * created on 17/05/2024
 */
sealed class Resource<out T>(
    val message: String? = null
) {
    data class Error(
        val error: Throwable
    ): Resource<Nothing>()

    data class Success<T>(
        val data: T
    ): Resource<T>()

    data object Idle: Resource<Nothing>()
    data object Loading : Resource<Nothing>()
}