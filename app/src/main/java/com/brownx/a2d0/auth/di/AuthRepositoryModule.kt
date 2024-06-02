package com.brownx.a2d0.auth.di

import com.brownx.a2d0.auth.data.repository.AuthRepositoryImpl
import com.brownx.a2d0.auth.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class AuthRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

}