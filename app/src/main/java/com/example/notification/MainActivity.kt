package com.example.notification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.notification.service.AlarmMaker

const val TAG = "MainActivityMain"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize alarm service
        AlarmMaker(this)
    }
}