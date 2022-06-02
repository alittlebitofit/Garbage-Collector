package com.example.notification.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class AlarmService: Service() {

    init {
        createAlarm()
    }

    private fun createAlarm() {

    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

}