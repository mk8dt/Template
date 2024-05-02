package com.mk.template.ui.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.domain.dto.UserDTO
import com.mk.domain.usecase.credentials.DoRegisterUseCase
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val doRegisterUseCase: DoRegisterUseCase
) : ViewModel() {

    fun doRegister(credentials: UserDTO) {

        viewModelScope.launch {

            if (!validateEmail(credentials.name)) return@launch

            if (!validatePasswordCondition(credentials.password)) return@launch

            doRegisterUseCase.doRegister(credentials)
                .collect { result ->
                    result.fold(
                        onSuccess = {},
                        onFailure = {}
                    )
                }
        }
    }

    private fun validateEmail(email: String): Boolean {
        //TODO make validations
        return true
    }

    private fun validatePasswordCondition(password: String): Boolean {
        //TODO make validations
        return true
    }
}
