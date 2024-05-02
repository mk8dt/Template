package com.mk.domain.usecase.credentials

import com.mk.domain.dto.UserDTO
import com.mk.domain.repository.CredentialsRepository
import kotlinx.coroutines.flow.Flow

interface DoRegisterUseCase {
    suspend fun doRegister(userDTO: UserDTO): Flow<Result<Unit>>
}

class DoRegisterUseCaseImpl(
    private val credentialsRepository: CredentialsRepository
) : DoRegisterUseCase {

    override suspend fun doRegister(userDTO: UserDTO): Flow<Result<Unit>> =
        credentialsRepository.doRegister(userDTO)
}
