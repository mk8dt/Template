package com.mk.template.ui.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.domain.dto.UserDTO
import com.mk.domain.usecase.credentials.DoLoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val doLoginUseCase: DoLoginUseCase
) : ViewModel() {

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Initial)
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    fun doLogin(credentials: UserDTO) {

        _loginState.value = LoginState.Loading

        viewModelScope.launch {
            doLoginUseCase.doLogin(credentials)
            _loginState.value = LoginState.Success
        }
    }

}
