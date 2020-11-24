package com.example.app_4a

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    val ctr: MutableLiveData<Int> = MutableLiveData()

    init {
        ctr.value = 0
    }
    fun onClickIncrement() {
        ctr.value = (ctr.value ?: 0) + 1
    }
}