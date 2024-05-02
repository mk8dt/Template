package com.mk.domain.usecase.credentials

import com.mk.domain.dto.UserDTO
import com.mk.domain.repository.CredentialsRepository

interface DoLoginUseCase {
    suspend fun doLogin(userDTO: UserDTO)
}

class DoLoginUseCaseImpl(
    private val credentialsRepository: CredentialsRepository
) : DoLoginUseCase {

    override suspend fun doLogin(userDTO: UserDTO) {

    }
}
