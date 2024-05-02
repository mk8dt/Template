package com.mk.data.api

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mk.data.response.NotificationResponse
import com.mk.domain.dto.NotificationDTO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockApi(private val context: Context) {

    suspend fun getNotifications(): Flow<Result<NotificationResponse>> {
        delay(1000)
        val jsonString = context.assets.open("notification.json").bufferedReader().use { it.readText() }
        val notificationList = parseJsonToList(jsonString)
        return flow { emit(Result.success(notificationList)) }
    }

    private fun parseJsonToList(jsonString: String): NotificationResponse {
        val gson = Gson()
        return gson.fromJson(jsonString, object : TypeToken<NotificationResponse>() {}.type)
    }
}

