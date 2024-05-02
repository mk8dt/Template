package com.mk.data.repository

import com.mk.data.datasource.NotificationRemoteDataSource
import com.mk.domain.dto.NotificationDTO
import com.mk.domain.repository.NotificationRepository
import kotlinx.coroutines.flow.Flow

class NotificationRepositoryImpl(
    private val notificationRemoteDataSource: NotificationRemoteDataSource
) : NotificationRepository {

    override suspend fun getAllNotifications(): Flow<Result<List<NotificationDTO>>> =
        notificationRemoteDataSource.getAllNotifications()
}
