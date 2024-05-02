package com.mk.template.ui.components.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import com.mk.template.R

@Composable
fun TextSection(label: String) {

    Text(
        text = label,
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onBackground
        )
    )
}

@Composable
@PreviewLightDark
fun TextSectionPreview() {
    TextSection(stringResource(R.string.appearance))
}