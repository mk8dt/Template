package com.mk.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mk.domain.dto.UserDTO

@Entity(tableName = "UserDBO")
data class UserDBO(
    @PrimaryKey(autoGenerate = true)
    val userID: Int = 0,
    val name: String,
)

fun UserDTO.toDBO() = UserDBO(name = name)
