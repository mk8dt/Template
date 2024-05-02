package com.mk.template.ui.screen.notifications

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mk.domain.dto.NotificationDTO
import com.mk.template.R
import com.mk.template.ui.components.Spacer4
import com.mk.template.ui.components.items.NotificationItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun NotificationsScreen(viewModel: NotificationsViewModel = koinViewModel()) {

    viewModel.fetchAllNotifications()

    when (val state = viewModel.notificationState.collectAsState().value) {
        NotificationState.Empty -> EmptyNotifications()
        is NotificationState.Error -> ShowError(state.errorMessage)
        NotificationState.Loading -> ShowLoading()
        is NotificationState.Success -> NotificationPage(notificationList = state.notificationList)
    }
}

@Composable
fun NotificationPage(notificationList: List<NotificationDTO>) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(notificationList) { item ->
            NotificationItem(notification = item)
            Spacer4()
            HorizontalDivider(color = MaterialTheme.colorScheme.onTertiary.copy(alpha = 0.5f))
            Spacer4()
        }
    }
}

@Composable
fun ShowError(errorMessage: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = errorMessage)
    }
}

@Composable
fun ShowLoading() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun EmptyNotifications() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = stringResource(R.string.empty_notifications))
    }
}

@Composable
@PreviewLightDark
fun NotificationsScreenPreview() {
    NotificationPage(notificationList = listOf())
}