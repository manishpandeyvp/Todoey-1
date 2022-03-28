package com.example.todoey.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.todoey.R
import com.example.todoey.ui.authenticate.AuthenticateActivity
import com.example.todoey.ui.authenticate.login.LoginActivity
import com.example.todoey.utils.Internet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this@MainActivity, LoginActivity::class.java))
    }
}