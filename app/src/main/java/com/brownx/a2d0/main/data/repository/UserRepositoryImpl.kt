package com.brownx.a2d0.main.data.repository

import com.brownx.a2d0.main.data.local.user.UserEntity
import com.brownx.a2d0.main.data.local.user.UserDAO

import com.brownx.a2d0.main.domain.repository.UserRepository
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
class UserRepositoryImpl @Inject constructor(
    private val userDAO: UserDAO
) : UserRepository {

    override suspend fun insertUser(userEntity: UserEntity) = userDAO.insertUser(userEntity)

    override suspend fun deleteUser(userEntity: UserEntity) = userDAO.deleteUser(userEntity)

}