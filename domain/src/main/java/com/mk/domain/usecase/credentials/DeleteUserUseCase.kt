package com.mk.domain.usecase.credentials

import com.mk.domain.repository.CredentialsRepository
import kotlinx.coroutines.flow.Flow

interface DeleteUserUseCase {
    suspend fun deleteUser(): Flow<Result<Unit>>
}

class DeleteUserUseCaseImpl(
    private val credentialsRepository: CredentialsRepository
) : DeleteUserUseCase {
    override suspend fun deleteUser(): Flow<Result<Unit>> = credentialsRepository.deleteUser()
}