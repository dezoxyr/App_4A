package com.example.app_4a.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.app_4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.login.observe(this, Observer {
            when(it){
                is LoginSuccess -> {

                }
                is LoginError -> {
                    MaterialAlertDialogBuilder(this)
                            .setTitle("Erreur")
                            .setMessage(it.msg)
                            .setPositiveButton("OK"){ dialog, which ->
                                dialog.dismiss()
                            }
                            .show()
                }
            }
        })
        login_button.setOnClickListener{
            mainViewModel.onClickLogin(login_edit.text.toString().trim(), password_edit.text.toString())
        }
        create_button.setOnClickListener{
            mainViewModel.onClickCreate(login_edit.text.toString().trim(), password_edit.text.toString())
        }
    }
}