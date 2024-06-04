package com.brownx.a2d0.main.presenter

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */
sealed class MainUiEvents {

    data object LoadAllRemoteData : MainUiEvents()
}