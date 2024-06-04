package com.brownx.a2d0.friends.di

import android.content.Context
import androidx.room.Room
import com.brownx.a2d0.friends.data.local.FriendsDatabase
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
object FriendsModule {

    @Singleton
    @Provides
    fun provideFriendsDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        FriendsDatabase::class.java,
        Const.USER_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideUserDao(db: FriendsDatabase) = db.getFriendsDao()

}