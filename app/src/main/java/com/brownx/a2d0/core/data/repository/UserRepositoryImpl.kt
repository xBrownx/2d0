package com.brownx.a2d0.core.data.repository

import com.brownx.a2d0.core.data.local.user.User
import com.brownx.a2d0.core.data.local.user.UserDAO

import com.brownx.a2d0.core.domain.repository.UserRepository
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
class UserRepositoryImpl @Inject constructor(
    private val userDAO: UserDAO
) : UserRepository {

    override suspend fun insertUser(user: User) = userDAO.insertUser(user)

    override suspend fun deleteUser(user: User) = userDAO.deleteUser(user)

}