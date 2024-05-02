package com.mk.domain.repository

import com.mk.domain.dto.UserDTO
import kotlinx.coroutines.flow.Flow

interface CredentialsRepository {

    suspend fun doLogin()

    suspend fun doRegister(userDTO: UserDTO): Flow<Result<Unit>>

    suspend fun deleteUser(): Flow<Result<Unit>>
}
