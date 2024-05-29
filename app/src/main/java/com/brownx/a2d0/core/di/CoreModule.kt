package com.brownx.a2d0.core.di

import androidx.room.Room
import android.app.Application
import android.content.Context
import com.brownx.a2d0.core.data.local.group.GroupDatabase
import com.brownx.a2d0.core.data.local.task.TaskDatabase
import com.brownx.a2d0.core.data.local.user.UserDatabase
import com.brownx.a2d0.util.Const
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
object CoreModule {

    @Singleton
    @Provides
    fun provideTaskDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        TaskDatabase::class.java,
        Const.TASK_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideGroupDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        GroupDatabase::class.java,
        Const.GROUP_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideUserDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        UserDatabase::class.java,
        Const.USER_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideTaskDao(db: TaskDatabase) = db.getTaskDao()

    @Singleton
    @Provides
    fun provideGroupDao(db: GroupDatabase) = db.getGroupDao()

    @Singleton
    @Provides
    fun provideUserDao(db: UserDatabase) = db.getUserDao()

    @Singleton
    @Provides
    fun provideContext(
        application: Application
    ): Context = application.applicationContext
}