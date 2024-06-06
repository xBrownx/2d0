package com.brownx.a2d0.util

/**
 * @author Andrew Brown
 * created on 17/05/2024
 */
sealed class Resource<out T>(
    val message: String? = null
) {
    data class Error(
        val error: String
    ) : Resource<Nothing>()

    data class Success<T>(
        val data: T
    ) : Resource<T>()

    data class Loading<T>(
        val isLoading: Boolean = true
    ) : Resource<T>(null)

    data object Idle: Resource<Nothing>()

}