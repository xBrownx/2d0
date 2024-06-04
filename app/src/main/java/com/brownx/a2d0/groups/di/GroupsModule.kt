package com.brownx.a2d0.groups.di

import android.content.Context
import androidx.room.Room
import com.brownx.a2d0.groups.data.local.GroupDatabase
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
object GroupsModule {

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
    fun provideGroupDao(db: GroupDatabase) = db.getGroupDao()
}