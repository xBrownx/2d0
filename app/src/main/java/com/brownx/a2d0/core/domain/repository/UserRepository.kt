package com.brownx.a2d0.core.domain.repository

import com.brownx.a2d0.core.data.local.user.User


/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
interface UserRepository {

    suspend fun insertUser(user: User)

    suspend fun deleteUser(user: User)

}