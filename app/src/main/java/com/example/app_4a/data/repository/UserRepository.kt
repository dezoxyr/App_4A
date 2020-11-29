package com.example.app_4a.data.repository

import com.example.app_4a.data.repository.local.DatabaseDao
import com.example.app_4a.data.repository.local.toData
import com.example.app_4a.data.repository.local.toEntity
import com.example.app_4a.domain.n1.entity.User

class UserRepository(private val databaseDao: DatabaseDao) {
    suspend fun createUser(user: User){
        databaseDao.insert(user.toData())
    }

    fun getUser(email: String, password: String) : User?{
        val userLocal = databaseDao.findByMail(email,password)
        return userLocal?.toEntity()
    }
}