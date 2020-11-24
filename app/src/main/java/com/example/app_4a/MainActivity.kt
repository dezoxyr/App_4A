package com.example.app_4a

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_button.setOnClickListener{
            mainViewModel.onClickIncrement()
        }
        mainViewModel.ctr.observe(this, Observer {
            main_text.text = it.toString()
        })
    }
}