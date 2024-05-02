package com.mk.template.data

import android.content.SharedPreferences
import com.mk.template.ui.theme.AppTheme

class TemplateSharedPreferences(private val sharedPreferences: SharedPreferences) {

    companion object {
        const val APP_THEME = "APP_THEME"
    }

    fun saveTheme(theme: AppTheme) = sharedPreferences.edit().putString(APP_THEME, theme.name).apply()
    fun getTheme(): AppTheme {
        val theme = sharedPreferences.getString(APP_THEME, AppTheme.LIGHT.name)
        return AppTheme.valueOf(theme ?: AppTheme.LIGHT.name)
    }
}
