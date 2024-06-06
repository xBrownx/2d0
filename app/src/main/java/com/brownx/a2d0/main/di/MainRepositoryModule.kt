package com.brownx.a2d0.main.di

import com.brownx.a2d0.main.data.repository.MainRepositoryImpl
import com.brownx.a2d0.main.domain.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Andrew Brown
 * created on 5/06/2024
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class MainRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMainRepository(
        mainRepositoryImpl: MainRepositoryImpl
    ) : MainRepository
}