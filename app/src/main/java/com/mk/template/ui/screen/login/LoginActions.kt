package com.mk.template.ui.screen.login

import com.mk.domain.dto.UserDTO

sealed class LoginActions {
    data class DoLogin(val credentials: UserDTO) : LoginActions()
    data object NavigateRegister : LoginActions()
}
