package com.brownx.a2d0.auth.domain.usecase

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
class ValidatePasswordUseCase {
    operator fun invoke(password: String): Boolean {
        return password.length >= 8 &&
                password.any { it.isUpperCase() } &&
                password.any { it.isDigit() }
    }
}