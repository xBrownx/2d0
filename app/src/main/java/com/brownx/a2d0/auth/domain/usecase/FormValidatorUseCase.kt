package com.brownx.a2d0.auth.domain.usecase

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
data class FormValidatorUseCase (
    val validateEmailUseCase: ValidateEmailUseCase,
    val validateMobileUseCase: ValidateMobileUseCase,
    val validatePasswordUseCase: ValidatePasswordUseCase,
    val validateUsernameUseCase: ValidateUsernameUseCase
)