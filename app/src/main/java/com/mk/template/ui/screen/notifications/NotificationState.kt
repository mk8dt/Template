package com.mk.template.ui.screen.notifications

import com.mk.domain.dto.NotificationDTO

sealed interface NotificationState {
    data object Loading : NotificationState
    data class Success(val notificationList: List<NotificationDTO>) : NotificationState
    data object Empty : NotificationState
    data class Error(val errorMessage: String) : NotificationState
}
