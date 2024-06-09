package com.brownx.a2d0.auth.data.repository

import android.annotation.SuppressLint
import android.app.Application
import android.content.SharedPreferences
import android.provider.Settings.Secure
import com.brownx.a2d0.auth.data.remote.AuthApi
import com.brownx.a2d0.auth.data.remote.dto.AuthRequest
import com.brownx.a2d0.auth.domain.repository.AuthRepository
import com.brownx.a2d0.auth.util.AuthResult
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val prefs: SharedPreferences,
    private val application: Application
) : AuthRepository {
    override suspend fun register(
        username: String,
        mobile: String,
        password: String
    ): AuthResult<Unit> {
        return try {

            val deviceId = Secure.getString(
                application.contentResolver,
                Secure.ANDROID_ID
            )

            val response = authApi.register(
                AuthRequest(
                    username = username,
                    mobile = mobile,
                    deviceId = deviceId,
                    password = password)
            )
            if(response.result) {
                Timber.d("register successful with message: ${response.msg}")
                login(username, password)
            } else {
                Timber.d("register failed with message: ${response.msg}")
                AuthResult.Unauthorized()
            }


        } catch (e: HttpException) {
            e.printStackTrace()
            login(username, password)
            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            AuthResult.UnknownError()
        }
    }

    @SuppressLint("HardwareIds")
    override suspend fun login(
        username: String,
        password: String
    ): AuthResult<Unit> {
        return try {

            val deviceId = Secure.getString(
                application.contentResolver,
                Secure.ANDROID_ID
            )

            val response = authApi.login(
                authRequest = AuthRequest(
                    username = username,
                    deviceId = deviceId,
                    password = password
                )
            )
            Timber.d("login token = ${response.token}")

            if(response.result) {
                Timber.d("login successful with message: ${response.msg}")
                prefs.edit().putString("username", response.username).apply()
                prefs.edit().putString("token", response.token).apply()
                prefs.edit().putString("device_id", deviceId).apply()
                AuthResult.Authorized()
            } else {
                Timber.d("login failed with message: ${response.msg}")
                Timber.d("username: ${response.username}")
                Timber.d("token: ${response.token}")
                AuthResult.Unauthorized()
            }

        } catch (e: HttpException) {
            e.printStackTrace()
            println(e.message)
            Timber.d("HttpException Error")
            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            Timber.d("Unknown Error")
            e.printStackTrace()
            println(e.message)
            AuthResult.UnknownError()
        }
    }

    override suspend fun authenticate(): AuthResult<Unit> {
        Timber.d("AUTHENTICATING")
        return try {

            val username = prefs.getString("username", null)
                ?: return AuthResult.Unauthorized()
            Timber.d("username = $username")
            val token = prefs.getString("token", null)
                ?: return AuthResult.Unauthorized()
            Timber.d("token = $token")
            val deviceId = prefs.getString("device_id", null)
                ?: return AuthResult.Unauthorized()
            Timber.d("device_id = $deviceId")


            val response = authApi.authenticate(
                authRequest = AuthRequest(
                    username = username,
                    deviceId = deviceId,
                    token = token
                )
            )
            if(response.result) {
                Timber.d("auth successful with message: ${response.msg}")
                AuthResult.Authorized()
            } else {
                Timber.d("auth failed with message: ${response.msg}")
                AuthResult.Unauthorized()
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            if (e.code() == 401) {
                AuthResult.Authorized()
            } else {
                AuthResult.Authorized()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            AuthResult.Authorized()
        }
    }

    override suspend fun logout(): AuthResult<Unit> {

        val username = prefs.getString("username", null)!!
        val token = prefs.getString("token", null)!!
        val deviceId = prefs.getString("device_id", null)!!

        try {
            authApi.logout(
                authRequest = AuthRequest(
                    username = username,
                    deviceId = deviceId,
                    token = token
                )
            )
        } catch (e: HttpException) {
            Timber.d("HttpException Error")
        } catch (e: Exception) {
            Timber.d("Unknown Error")
            e.printStackTrace()
        }
        //mainRepository.clearMainDb()
        //favoritesRepository.clearMainDb()

        prefs.edit().putString("username", null).apply()
        prefs.edit().putString("device_id", null).apply()
        prefs.edit().putString("token", null).apply()


        return AuthResult.SingedOut()
    }


}
