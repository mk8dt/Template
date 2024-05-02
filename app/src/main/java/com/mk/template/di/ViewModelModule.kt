package com.mk.template.di

import com.mk.template.ui.screen.home.HomeViewModel
import com.mk.template.ui.screen.login.LoginViewModel
import com.mk.template.ui.screen.notifications.NotificationsViewModel
import com.mk.template.ui.screen.profile.ProfileViewModel
import com.mk.template.ui.screen.register.RegisterViewModel
import com.mk.template.ui.screen.settings.SettingsViewModel
import com.mk.template.ui.screen.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {

    viewModelOf(::SplashViewModel)

    viewModelOf(::LoginViewModel)
    viewModelOf(::RegisterViewModel)

    viewModelOf(::HomeViewModel)
    viewModelOf(::ProfileViewModel)
    viewModelOf(::SettingsViewModel)

    viewModelOf(::NotificationsViewModel)
}
