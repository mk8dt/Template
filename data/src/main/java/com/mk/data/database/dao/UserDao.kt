package com.mk.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mk.data.database.entity.UserDBO

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createUser(userDBO: UserDBO)

    @Query("SELECT * FROM UserDBO")
    suspend fun getUser(): UserDBO?

    @Delete
    suspend fun deleteUser(userDBO: UserDBO)
}
