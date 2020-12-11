package com.example.app_4a.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app_4a.R
import org.koin.android.ext.android.inject

class SecondActivity : AppCompatActivity(){
    val secondViewModel : SecondViewModel by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val image = "https://m.media-amazon.com/images/M/MV5BZjg5MzExMGItZDk0NS00ZmI5LTg4YzktYTUzMjY2Zjg1ZjczXkEyXkFqcGdeQXVyNzU1NzE3NTg@._V1_CR0,45,480,270_AL_UX477_CR0,0,477,268_AL_.jpg"
        secondViewModel.runAPI("https://trace.moe/api/search?url="+image)


    }
}