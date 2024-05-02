package com.mk.template.ui.screen.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.mk.template.R
import com.mk.template.ui.components.text.TextSection
import com.mk.template.ui.theme.AppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingsScreen(viewModel: SettingsViewModel = koinViewModel()) {
    SettingsPage(
        isDarkMode = false,
        onChangeTheme = { appTheme -> viewModel.updateTheme(appTheme) }
    )
}

@Composable
fun SettingsPage(
    isDarkMode: Boolean,
    onChangeTheme: (AppTheme) -> Unit
) {

    var checked by remember { mutableStateOf(isDarkMode) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextSection(stringResource(R.string.appearance))
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = checked,
                onCheckedChange = {
                    onChangeTheme(if (it) AppTheme.DARK else AppTheme.LIGHT)
                    checked = it
                },
                colors = SwitchDefaults.colors(
                    uncheckedTrackColor = MaterialTheme.colorScheme.onTertiary,
                    uncheckedThumbColor = MaterialTheme.colorScheme.background,
                    uncheckedBorderColor = MaterialTheme.colorScheme.background,
                    checkedTrackColor = MaterialTheme.colorScheme.onTertiary,
                    checkedThumbColor = MaterialTheme.colorScheme.background,
                    checkedBorderColor = MaterialTheme.colorScheme.background
                ),
                thumbContent = {
                    val icon = if (checked) Icons.Outlined.DarkMode else Icons.Outlined.LightMode
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize),
                        tint = MaterialTheme.colorScheme.onTertiary
                    )
                }
            )
        }
    }
}

@Composable
@PreviewLightDark
fun SettingsScreenPreview() {
    SettingsPage(
        isDarkMode = false,
        onChangeTheme = {}
    )
}