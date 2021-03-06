package com.example.app_4a.injection

import android.content.Context
import androidx.room.Room
import com.example.app_4a.data.repository.UserRepository
import com.example.app_4a.data.repository.local.AppDatabase
import com.example.app_4a.data.repository.local.DatabaseDao
import com.example.app_4a.domain.n1.usecase.CreateUserUseCase
import com.example.app_4a.domain.n1.usecase.GetUserUseCase
import com.example.app_4a.presentation.main.MainViewModel
import com.example.app_4a.presentation.main.SecondViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val presentationModule = module{
    factory { MainViewModel(get(),get()) }
}

val domainModule = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule = module {
    single { UserRepository(get()) }
    single { createDataBase(androidContext()) }
}

val secondModule = module{
    factory { SecondViewModel()}
}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database"
    ).build()
    return appDatabase.databaseDao()
}
