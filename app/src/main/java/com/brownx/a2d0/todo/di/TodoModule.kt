package com.brownx.a2d0.todo.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.brownx.a2d0.todo.data.local.TaskDatabase
import com.brownx.a2d0.util.Const.TASK_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Module
@InstallIn(SingletonComponent::class)
object TodoModule {

    @Singleton
    @Provides
    fun provideTaskDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        TaskDatabase::class.java,
        TASK_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRunDao(db: TaskDatabase) = db.getTaskDao()

    @Singleton
    @Provides
    fun provideContext(
        application: Application
    ): Context = application.applicationContext
}