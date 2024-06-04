package com.brownx.a2d0.tasks.di

import android.content.Context
import androidx.room.Room
import com.brownx.a2d0.tasks.data.local.TaskDatabase
import com.brownx.a2d0.util.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */

@Module
@InstallIn(SingletonComponent::class)
object TasksModule {

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
    fun provideTaskDao(db: TaskDatabase) = db.getTaskDao()

}