package com.brownx.a2d0.settings.presenter

/**
 * @author Andrew Brown
 * created on 5/06/2024
 */
sealed class SettingsUiEvents {

    data object Logout : SettingsUiEvents()
}