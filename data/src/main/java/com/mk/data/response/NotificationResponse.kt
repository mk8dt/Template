package com.mk.data.response

import com.mk.domain.dto.NotificationDTO

data class NotificationResponse(
    val status: String,
    val code: Int,
    val message: String,
    val data: List<NotificationDTO>
)