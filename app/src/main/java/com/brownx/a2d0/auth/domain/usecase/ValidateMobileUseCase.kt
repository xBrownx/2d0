package com.brownx.a2d0.auth.domain.usecase

import android.util.Patterns

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */

class ValidateMobileUseCase {
    operator fun invoke(mobile: String): Boolean {
        return Patterns.PHONE.matcher(
            mobile
        ).matches()
    }
}