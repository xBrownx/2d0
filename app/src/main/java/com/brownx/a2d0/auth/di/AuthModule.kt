package com.brownx.a2d0.auth.di

import android.content.SharedPreferences
import com.brownx.a2d0.auth.data.remote.AuthApi
import com.brownx.a2d0.auth.domain.usecase.FormValidatorUseCase
import com.brownx.a2d0.auth.domain.usecase.ValidateEmailUseCase
import com.brownx.a2d0.auth.domain.usecase.ValidateMobileUseCase
import com.brownx.a2d0.auth.domain.usecase.ValidatePasswordUseCase
import com.brownx.a2d0.auth.domain.usecase.ValidateUsernameUseCase
import com.brownx.a2d0.main.data.remote.MainApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */

@Module
@InstallIn(SingletonComponent::class)
class AuthModule {

    @Provides
    @Singleton
    fun provideAuthApi(): AuthApi {
        return Retrofit.Builder()
            .baseUrl(MainApi.SERVER_IP)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFromValidatorUseCase(): FormValidatorUseCase {
        return FormValidatorUseCase(
            ValidateEmailUseCase(),
            ValidateMobileUseCase(),
            ValidatePasswordUseCase(),
            ValidateUsernameUseCase()
        )
    }
}