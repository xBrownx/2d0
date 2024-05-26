package com.brownx.a2d0.todo.di

import com.brownx.a2d0.todo.data.repository.TodoRepositoryImpl
import com.brownx.a2d0.todo.domain.repository.TodoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class TodoRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindTodoRepository(
        todoRepositoryImpl: TodoRepositoryImpl
    ) : TodoRepository
}