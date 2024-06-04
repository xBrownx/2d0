package com.brownx.a2d0.friends.di

import com.brownx.a2d0.friends.data.repository.FriendsRepositoryImpl
import com.brownx.a2d0.friends.domain.repository.FriendsRepository
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
abstract class FriendsRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindFriendsRepository(
        friendsRepositoryImpl: FriendsRepositoryImpl
    ) : FriendsRepository

}