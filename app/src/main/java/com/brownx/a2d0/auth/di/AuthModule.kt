package com.brownx.a2d0.auth.di

import android.app.Application
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.brownx.a2d0.auth.data.remote.AuthApi
import com.brownx.a2d0.auth.domain.usecase.CreatePersonalGroupUseCase
import com.brownx.a2d0.auth.domain.usecase.FormValidatorUseCase
import com.brownx.a2d0.auth.domain.usecase.ValidateEmailUseCase
import com.brownx.a2d0.auth.domain.usecase.ValidateMobileUseCase
import com.brownx.a2d0.auth.domain.usecase.ValidatePasswordUseCase
import com.brownx.a2d0.auth.domain.usecase.ValidateUsernameUseCase
import com.brownx.a2d0.util.Const.SERVER_IP
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
            .baseUrl(SERVER_IP)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    fun provideEncryptedSharedPrefs(
        application: Application
    ): SharedPreferences {

        val masterKey = MasterKey.Builder(application)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        return EncryptedSharedPreferences.create(
            application,
            "todo_app_prefs",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
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

    @Provides
    @Singleton
    fun provideCreatePersonalGroupUseCase(prefs: SharedPreferences): CreatePersonalGroupUseCase {
        return CreatePersonalGroupUseCase(prefs = prefs)
    }
}