package com.mk.data.datasource

import com.mk.data.api.MockApi
import com.mk.domain.dto.NotificationDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class NotificationRemoteDataSource(private val mockApi: MockApi) {

    suspend fun getAllNotifications(): Flow<Result<List<NotificationDTO>>> =
        mockApi.getNotifications()
            .map { result ->
                result.fold(
                    onSuccess = { response -> Result.success(response.data) },
                    onFailure = { error -> Result.failure(error) }
                )
            }
            .catch { exception ->
                emit(Result.failure(exception))
            }

    suspend fun getNotificationByIdentifier(notificationId: Int): Flow<Result<NotificationDTO>> = callbackFlow{

    }
}
