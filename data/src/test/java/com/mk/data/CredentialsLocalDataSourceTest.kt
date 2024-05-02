package com.mk.data

import com.mk.data.database.dao.UserDao
import com.mk.data.database.entity.UserDBO
import com.mk.data.datasource.CredentialsLocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class CredentialsLocalDataSourceTest {

    @Mock
    lateinit var mockUserDao: UserDao
    private lateinit var localDataSource: CredentialsLocalDataSource
    private val dispatcher: TestDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(dispatcher)
        localDataSource = CredentialsLocalDataSource(mockUserDao)
    }

    @Test
    fun `test registerAccount success`() = runBlocking {

        val userDBO = UserDBO(0, "")
        `when`(mockUserDao.createUser(userDBO)).then { }

        val resultFlow = localDataSource.registerAccount(userDBO)
        val result = resultFlow.single()

        assertEquals(Result.success(Unit), result)
    }

    @Test
    fun `test registerAccount failure`() = runBlocking {

        val userDBO = UserDBO(0, "")
        val errorMessage = "An error occurred"
        `when`(mockUserDao.createUser(userDBO)).thenReturn(null)

        val resultFlow = localDataSource.registerAccount(userDBO)
        val result = resultFlow.single()

        assertEquals(Result.failure<Unit>(Exception(errorMessage)), result)
    }

    @Test
    fun `test deleteAccount success`() = runBlocking {

        val userDBO = UserDBO(0, "")
        `when`(mockUserDao.getUser()).thenReturn(userDBO)
        `when`(mockUserDao.deleteUser(userDBO)).then { }

        val resultFlow = localDataSource.deleteAccount()
        val result = resultFlow.single()

        assertEquals(Result.success(Unit), result)
    }

    @Test
    fun `test deleteAccount failure`() = runBlocking {
        val errorMessage = "An error occurred"
        `when`(mockUserDao.getUser()).thenReturn(null)

        val resultFlow = localDataSource.deleteAccount()
        val result = resultFlow.single()

        assertEquals(Result.failure<Unit>(Exception(errorMessage)), result)
    }

    @Test
    fun `test getUser success`() = runBlocking {

        val userDBO = UserDBO(0, "")
        `when`(mockUserDao.getUser()).thenReturn(userDBO)


        val resultFlow = localDataSource.getUser()
        val result = resultFlow.single()

        assertEquals(Result.success(userDBO), result)
    }

    @Test
    fun `test getUser failure`() = runBlocking {

        val errorMessage = "An error occurred"
        `when`(mockUserDao.getUser()).thenReturn(null)

        val resultFlow = localDataSource.getUser()
        val result = resultFlow.single()

        assertEquals(Result.failure<UserDBO>(Exception(errorMessage)), result)
    }
}
