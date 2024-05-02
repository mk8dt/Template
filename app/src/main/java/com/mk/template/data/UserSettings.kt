package com.mk.template.data

import com.mk.template.ui.theme.AppTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

interface UserSettings {
    val themeStream: StateFlow<AppTheme>
    var theme: AppTheme
}

class UserSettingsImpl(
    private val templateSharedPreferences: TemplateSharedPreferences
) : UserSettings {

    override val themeStream: MutableStateFlow<AppTheme>
    override var theme: AppTheme by AppThemePreferenceDelegate()

    init {
        themeStream = MutableStateFlow(theme)
    }

    inner class AppThemePreferenceDelegate : ReadWriteProperty<Any?, AppTheme> {

        override fun getValue(thisRef: Any?, property: KProperty<*>): AppTheme = templateSharedPreferences.getTheme()

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: AppTheme) {
            themeStream.value = value
            templateSharedPreferences.saveTheme(value)
        }
    }
}
