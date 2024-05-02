package com.mk.template.ui.screen.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mk.domain.dto.UserDTO
import com.mk.template.ui.components.Spacer16
import com.mk.template.ui.components.Spacer24
import com.mk.template.ui.components.Spacer32
import com.mk.template.ui.components.button.LargeButton
import com.mk.template.ui.components.textfield.CredentialsTextField
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = koinViewModel(),
    navController: NavController
) {

    RegisterPage { viewModel.doRegister(it) }

}

@Composable
fun RegisterPage(doRegister: (UserDTO) -> Unit) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Icon(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally),
            imageVector = Icons.Default.AccountCircle,
            contentDescription = ""
        )
        Spacer32()

        CredentialsTextField(
            value = username,
            label = "Username",
            icon = Icons.Default.AccountBox,
            onValueChange = { username = it }
        )

        Spacer16()

        CredentialsTextField(
            value = password,
            label = "Password",
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(),
            icon = Icons.Default.Lock,
            onValueChange = { password = it }
        )

        Spacer24()

        LargeButton(
            label = "Create Account",
            onClick = { doRegister(UserDTO(0, username, password)) }
        )
    }
}

@Composable
@PreviewLightDark
fun RegisterScreenPreview() {
    RegisterPage {}
}