package com.example.app_4a.presentation.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_4a.domain.n1.entity.User
import com.example.app_4a.domain.n1.usecase.CreateUserUseCase
import com.example.app_4a.domain.n1.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val createUserUseCase: CreateUserUseCase, val getUserUseCase: GetUserUseCase) : ViewModel() {


    val ctr: MutableLiveData<Int> = MutableLiveData()

    init {
        ctr.value = 0
    }
    fun onClickIncrement(emailUser: String) {
        viewModelScope.launch(Dispatchers.IO) {
            createUserUseCase.invoke(User("test"))
            val user = getUserUseCase.invoke("test")
            Log.d("tag",user.toString())
        }
        //ctr.value = (ctr.value ?: 0) + 1
    }
}