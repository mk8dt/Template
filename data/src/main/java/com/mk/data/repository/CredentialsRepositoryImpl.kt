package com.mk.data.repository

import com.mk.data.database.entity.toDBO
import com.mk.data.datasource.CredentialsLocalDataSource
import com.mk.domain.dto.UserDTO
import com.mk.domain.repository.CredentialsRepository
import kotlinx.coroutines.flow.Flow

class CredentialsRepositoryImpl(private val credentialsLocalDataSource: CredentialsLocalDataSource) : CredentialsRepository {

    override suspend fun doLogin() {
        //TODO Implement features
    }

    override suspend fun doRegister(userDTO: UserDTO): Flow<Result<Unit>> =
        credentialsLocalDataSource.registerAccount(userDTO.toDBO())


    override suspend fun deleteUser() : Flow<Result<Unit>> =
        credentialsLocalDataSource.deleteAccount()

}
