package com.mk.template

import com.mk.domain.dto.NotificationDTO
import com.mk.domain.usecase.notification.GetAllNotificationUseCase
import com.mk.template.ui.screen.notifications.NotificationState
import com.mk.template.ui.screen.notifications.NotificationsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class NotificationViewModelTest {

    @Mock
    lateinit var mockGetAllNotificationUseCase: GetAllNotificationUseCase
    private lateinit var viewModel: NotificationsViewModel
    private val dispatcher: TestDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(dispatcher)
        viewModel = NotificationsViewModel(mockGetAllNotificationUseCase)
    }

    @Test
    fun `test fetchAllNotifications success`(): Unit = runBlocking {

        val notifications = listOf(NotificationDTO("", "", "", ""))
        `when`(mockGetAllNotificationUseCase.fetchAllNotification()).thenReturn(flowOf(Result.success(notifications)))

        viewModel.fetchAllNotifications()

        val currentState = viewModel.notificationState.value
        assertTrue(currentState is NotificationState.Success && currentState.notificationList == notifications)
    }

    @Test
    fun `test fetchAllNotifications empty`(): Unit = runBlocking {

        val notifications = emptyList<NotificationDTO>()
        `when`(mockGetAllNotificationUseCase.fetchAllNotification()).thenReturn(flowOf(Result.success(notifications)))

        viewModel.fetchAllNotifications()

        assertEquals(NotificationState.Empty, viewModel.notificationState.value)
    }

    @Test
    fun `test fetchAllNotifications error`(): Unit = runBlocking {

        val errorMessage = "An error occurred"
        val exception = Exception(errorMessage)
        `when`(mockGetAllNotificationUseCase.fetchAllNotification()).thenReturn(flowOf(Result.failure(exception)))

        viewModel.fetchAllNotifications()

        val currentState = viewModel.notificationState.value
        assertTrue(currentState is NotificationState.Error && currentState.errorMessage == errorMessage)
    }
}
