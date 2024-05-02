package com.mk.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mk.data.database.dao.UserDao
import com.mk.data.database.entity.UserDBO

@Database(
    entities = [UserDBO::class],
    version = 1,
    exportSchema = false
)
abstract class TemplateDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}