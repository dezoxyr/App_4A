package com.example.app_4a.presentation.main

import androidx.lifecycle.ViewModel
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class SecondViewModel(): ViewModel() {

    private val client = OkHttpClient()


    fun runAPI(url: String){
        val request = Request.Builder()
                .url(url)
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                val rep = response.body()?.string()
                val json1 = JSONObject(JSONObject(rep).getJSONArray("docs").getString(0))
                val episode = json1.get("episode")
                println(episode)
                println("debug");
            }
        })
    }
}