package com.mk.data.datasource

import com.mk.data.database.dao.UserDao
import com.mk.data.database.entity.UserDBO
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.map

class CredentialsLocalDataSource(private val userDao: UserDao) {

    suspend fun registerAccount(userDBO: UserDBO): Flow<Result<Unit>> = callbackFlow {
        try {
            userDao.createUser(userDBO)
            send(Result.success(Unit))
        } catch (e: Exception) {
            send(Result.failure(e))
        }
        awaitClose()
    }

    suspend fun deleteAccount(): Flow<Result<Unit>> = callbackFlow {
        try {
            val user = getUser()
            user.map { result ->
                result
                    .onSuccess { userDBO ->
                        userDao.deleteUser(userDBO)
                        send(Result.success(Unit))
                    }
                    .onFailure { send(Result.failure(it)) }
            }
        } catch (e: Exception) {
            send(Result.failure(e))
        }
        awaitClose()
    }

    suspend fun getUser(): Flow<Result<UserDBO>> = callbackFlow {
        try {
            val user = userDao.getUser()
            user?.let { send(Result.success(user)) }
        } catch (e: Exception) {
            send(Result.failure(e))
        }
        awaitClose()
    }
}
