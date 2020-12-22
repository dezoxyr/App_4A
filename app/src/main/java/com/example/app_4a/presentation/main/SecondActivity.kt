package com.example.app_4a.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_4a.R
import com.example.app_4a.domain.n1.RecyclerViewAdaptater
import kotlinx.android.synthetic.main.activity_second.*
import org.koin.android.ext.android.inject

class SecondActivity : AppCompatActivity(){
    val secondViewModel : SecondViewModel by inject()
    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        //val image = "https://m.media-amazon.com/images/M/MV5BZjg5MzExMGItZDk0NS00ZmI5LTg4YzktYTUzMjY2Zjg1ZjczXkEyXkFqcGdeQXVyNzU1NzE3NTg@._V1_CR0,45,480,270_AL_UX477_CR0,0,477,268_AL_.jpg"




        url_button.setOnClickListener {
            val image = url_edit.text.toString().trim()
            if(image != null || image != "") {
                secondViewModel.runAPI("https://trace.moe/api/search?url=" + image)
            }

            while (true) {
                if(secondViewModel.flag) {
                    recycler = findViewById(R.id.list_recycler_view)
                    recycler.layoutManager = LinearLayoutManager(this)
                    recycler.adapter = RecyclerViewAdaptater(secondViewModel.test.toTypedArray())
                    break
                }
            }
        }


    }
}