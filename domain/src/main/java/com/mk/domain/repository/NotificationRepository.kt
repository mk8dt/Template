package com.mk.domain.repository

import com.mk.domain.dto.NotificationDTO
import kotlinx.coroutines.flow.Flow

interface NotificationRepository {

    suspend fun getAllNotifications(): Flow<Result<List<NotificationDTO>>>
}
