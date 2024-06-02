package com.brownx.a2d0.auth.domain.usecase

import android.util.Patterns

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
class ValidateEmailUseCase {
    operator fun invoke(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(
            email
        ).matches()
    }
}