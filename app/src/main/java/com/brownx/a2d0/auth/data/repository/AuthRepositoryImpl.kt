package com.brownx.a2d0.auth.data.repository

import android.content.SharedPreferences
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

) : AuthRepository {
    override suspend fun register(
        username: String,
        mobile: String,
        password: String
    ): AuthResult<Unit> {
        return try {
            authApi.register(
                AuthRequest(
                    username = username,
                    mobile = mobile,
                    password = password)
            )

            login(username, password)
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

    override suspend fun login(
        username: String,
        password: String
    ): AuthResult<Unit> {
        return try {

            val authRespond = authApi.login(
                authRequest = AuthRequest(username = username, password = password)
            )

            prefs.edit().putString("username", authRespond.username).apply()
            prefs.edit().putString("token", authRespond.token).apply()

            AuthResult.Authorized()

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
        return try {

            val username = prefs.getString("username", null)
                ?: return AuthResult.Unauthorized()
            val token = prefs.getString("token", null)
                ?: return AuthResult.Unauthorized()

            authApi.authenticate(authRequest = AuthRequest(username = username, token = token))

            AuthResult.Authorized()
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
        prefs.edit().putString("username", null).apply()
        prefs.edit().putString("name", null).apply()
        prefs.edit().putString("token", null).apply()

        //mainRepository.clearMainDb()
        //favoritesRepository.clearMainDb()

        return AuthResult.SingedOut()
    }


}
