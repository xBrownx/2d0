package com.brownx.a2d0.main.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.brownx.a2d0.auth.data.remote.AuthApi
import com.brownx.a2d0.main.data.remote.MainApi
import com.brownx.a2d0.util.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Singleton
    @Provides
    fun provideContext(
        application: Application
    ): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideMainApi(): MainApi {
        return Retrofit.Builder()
            .baseUrl(Const.SERVER_IP)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MainApi::class.java)
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

}