package com.example.app_4a.presentation.main

sealed class LoginStatus
data class LoginSuccess(val email: String): LoginStatus()
data class LoginError(val msg: String): LoginStatus()