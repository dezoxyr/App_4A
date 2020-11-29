package com.example.app_4a.data.repository.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DatabaseDao{
    @Query("SELECT * FROM userlocal")
    fun getAll(): List<UserLocal>

    @Query("SELECT * FROM userlocal WHERE email LIKE :email and password LIKE :password")
    fun findByMail(email: String,password: String): UserLocal?

    @Insert
    fun insert(user: UserLocal)

    @Delete
    fun delete(user: UserLocal)
}