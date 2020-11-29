package com.example.app_4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_4a.domain.n1.usecase.CreateUserUseCase
import com.example.app_4a.domain.n1.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(val createUserUseCase: CreateUserUseCase, val getUserUseCase: GetUserUseCase) : ViewModel() {


    val login: MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser,password)
            val loginStatus = if(user != null){
                LoginSuccess(user.email)
            }else{
                LoginError("User can't be resolved")
            }

            withContext(Dispatchers.Main) {
                login.value = loginStatus
            }
        }
    }

    fun onClickCreate(emailUser: String, password: String){
        //createUserUseCase.invoke(User("test","azerty"))
        //Log.d("tag",user.toString())
    }
}