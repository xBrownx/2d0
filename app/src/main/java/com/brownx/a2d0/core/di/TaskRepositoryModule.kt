package com.brownx.a2d0.core.di

import com.brownx.a2d0.core.data.repository.TaskRepositoryImpl
import com.brownx.a2d0.core.domain.repository.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class TaskRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindTaskRepository(
        taskRepositoryImpl: TaskRepositoryImpl
    ) : TaskRepository
}