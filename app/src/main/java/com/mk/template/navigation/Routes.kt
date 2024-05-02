package com.mk.template.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

const val SPLASH_ROUTE = "SPLASH"
const val LOGIN_ROUTE = "LOGIN"
const val REGISTER_ROUTE = "REGISTER"

const val HOME_ROUTE = "HOME"
const val PROFILE_ROUTE = "PROFILE"
const val SETTINGS_ROUTE = "SETTINGS"
const val NOTIFICATIONS_ROUTE = "NOTIFICATIONS"

sealed class Routes(val nameRoute: String) {
    data object SPLASH : Routes(SPLASH_ROUTE)
    data object LOGIN : Routes(LOGIN_ROUTE)
    data object REGISTER : Routes(REGISTER_ROUTE)
    data object HOME : Routes(HOME_ROUTE)
    data object PROFILE : Routes(PROFILE_ROUTE)
    data object SETTINGS : Routes(SETTINGS_ROUTE)
    data object NOTIFICATIONS : Routes(NOTIFICATIONS_ROUTE)
}


enum class ScreenBar(val route: String, val icon: ImageVector, val label: String) {
    HOME(Routes.HOME.nameRoute, Icons.Filled.Home, HOME_ROUTE),
    PROFILE(Routes.PROFILE.nameRoute, Icons.Filled.AccountCircle, PROFILE_ROUTE),
    SETTINGS(Routes.SETTINGS.nameRoute, Icons.Filled.Settings, SETTINGS_ROUTE)
}

private val mainRoute = listOf(
    ScreenBar.HOME.route,
    ScreenBar.PROFILE.route,
    ScreenBar.SETTINGS.route
)

fun String?.isMainRoute(): Boolean = mainRoute.contains(this)
