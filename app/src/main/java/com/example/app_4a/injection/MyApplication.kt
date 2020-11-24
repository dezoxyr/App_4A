package com.example.app_4a.injection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate(){
        super.onCreate()
        //startKoin !
        startKoin{
            //android context
            androidContext(this@MyApplication)
            //modules
            modules(presentationModule)
        }
    }
}