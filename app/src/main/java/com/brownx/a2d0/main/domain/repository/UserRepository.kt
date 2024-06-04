package com.brownx.a2d0.main.domain.repository

import com.brownx.a2d0.main.data.local.user.UserEntity


/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
interface UserRepository {

    suspend fun insertUser(userEntity: UserEntity)

    suspend fun deleteUser(userEntity: UserEntity)

}