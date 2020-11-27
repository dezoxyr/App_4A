package com.example.app_4a.data.repository.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.app_4a.domain.n1.entity.User

@Entity
data class UserLocal(@ColumnInfo(name = "email") val email: String){
    @PrimaryKey(autoGenerate = true )var uid: Int? = null
}

fun User.toData() : UserLocal{
    return UserLocal(
        email = this.email
    )
}

fun UserLocal.toEntity() : User{
    return User(
        email = this.email
    )
}