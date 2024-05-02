package com.mk.template.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mk.template.ui.screen.home.HomeScreen
import com.mk.template.ui.screen.login.LoginScreen
import com.mk.template.ui.screen.notifications.NotificationsScreen
import com.mk.template.ui.screen.profile.ProfileScreen
import com.mk.template.ui.screen.register.RegisterScreen
import com.mk.template.ui.screen.settings.SettingsScreen
import com.mk.template.ui.screen.splash.SplashScreen

@Composable
fun TemplateNavHost(navHostController: NavHostController, paddingValues: PaddingValues) {

    NavHost(
        navController = navHostController,
        startDestination = Routes.SPLASH.nameRoute,
        modifier = Modifier.padding(paddingValues)
    ) {

        composable(route = Routes.SPLASH.nameRoute) {
            SplashScreen(navController = navHostController)
        }

        composable(route = Routes.LOGIN.nameRoute) {
            LoginScreen(navController = navHostController)
        }

        composable(route = Routes.REGISTER.nameRoute) {
            RegisterScreen(navController = navHostController)
        }

        composable(route = Routes.HOME.nameRoute) {
            HomeScreen()
        }

        composable(route = Routes.PROFILE.nameRoute) {
            ProfileScreen()
        }

        composable(route = Routes.SETTINGS.nameRoute) {
            SettingsScreen()
        }

        composable(route = Routes.NOTIFICATIONS.nameRoute) {
            NotificationsScreen()
        }
    }

}
