package com.mk.template.ui.screen.login

sealed interface LoginState {
    data object Initial : LoginState
    data object Loading : LoginState
    data object Success : LoginState
    data class CredentialError(val errorMessage: String) : LoginState
}
