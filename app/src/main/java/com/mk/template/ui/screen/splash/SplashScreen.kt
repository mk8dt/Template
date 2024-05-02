package com.mk.template.ui.screen.splash

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.navigation.NavController
import com.mk.template.navigation.Routes
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = koinViewModel(),
    navController: NavController
) {
    navController.navigate(Routes.LOGIN.nameRoute)
}

@Composable
@PreviewLightDark
fun SplashScreenPreview() {

}