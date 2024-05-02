package com.mk.template.ui.screen.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.template.data.UserSettings
import com.mk.template.ui.theme.AppTheme
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val userSettings: UserSettings
) : ViewModel() {

    fun updateTheme(appTheme: AppTheme) {
        viewModelScope.launch {
            userSettings.theme = appTheme
        }
    }
}
