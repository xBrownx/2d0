package com.brownx.a2d0.auth.domain.usecase

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
class ValidateUsernameUseCase {
    operator fun invoke(name: String): Boolean {
        return name.length in 4..50
    }
}