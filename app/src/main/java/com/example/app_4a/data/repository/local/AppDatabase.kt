package com.example.app_4a.data.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(
    UserLocal::class
), version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun databaseDao(): DatabaseDao
}