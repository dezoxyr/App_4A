package com.example.app_4a.injection

import com.example.app_4a.MainViewModel
import org.koin.dsl.module

val presentationModule = module{
    factory {MainViewModel()}
}