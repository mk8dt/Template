package com.mk.domain.usecase.notification

import com.mk.domain.dto.NotificationDTO
import com.mk.domain.repository.NotificationRepository
import kotlinx.coroutines.flow.Flow

interface GetAllNotificationUseCase {
    suspend fun fetchAllNotification(): Flow<Result<List<NotificationDTO>>>
}

class GetAllNotificationUseCaseImpl(
    private val notificationRepository: NotificationRepository
) : GetAllNotificationUseCase {

    override suspend fun fetchAllNotification(): Flow<Result<List<NotificationDTO>>> =
        notificationRepository.getAllNotifications()

}
