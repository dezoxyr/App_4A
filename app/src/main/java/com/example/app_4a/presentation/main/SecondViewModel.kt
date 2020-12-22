package com.example.app_4a.presentation.main

import androidx.lifecycle.ViewModel
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class SecondViewModel(): ViewModel() {

    private val client = OkHttpClient()
    var test = ArrayList<String>()
    var flag : Boolean = false

    fun runAPI(url: String){
        val request = Request.Builder()
                .url(url)
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(e)
            }

            override fun onResponse(call: Call, response: Response){
                val rep = response.body()?.string()
                val json1 = JSONObject(JSONObject(rep).getJSONArray("docs").getString(0))
                val episode = json1.get("episode")
                val jTitle = json1.get("title_romaji")
                val eTitle =  json1.get("title_english")
                val similarity = json1.get("similarity")

                test.add("Romaji title : "+jTitle.toString())
                test.add("English title : "+eTitle.toString())
                test.add("Similarity : "+similarity.toString())
                test.add("Episode : "+episode.toString())
                flag = true
                println(json1)
                println(episode)
                println(similarity)
                println("debug");
            }
        })
    }
}