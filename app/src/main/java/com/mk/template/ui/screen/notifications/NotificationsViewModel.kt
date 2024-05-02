package com.mk.template.ui.screen.notifications

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.domain.usecase.notification.GetAllNotificationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NotificationsViewModel(
    private val getAllNotificationUseCase: GetAllNotificationUseCase
) : ViewModel() {

    private val _notificationState = MutableStateFlow<NotificationState>(NotificationState.Loading)
    val notificationState: StateFlow<NotificationState> = _notificationState.asStateFlow()

    fun fetchAllNotifications() {
        viewModelScope.launch {
            getAllNotificationUseCase.fetchAllNotification().collect { result ->
                result.fold(
                    onSuccess = {
                        _notificationState.value = if (it.isEmpty()) NotificationState.Empty else NotificationState.Success(it)
                    },
                    onFailure = {
                        _notificationState.value = NotificationState.Error(it.message ?: "Unexpected Error")
                    }
                )
            }
        }
    }
}
