package com.example.notification.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.notification.service.AlarmMaker

class LockedBootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_LOCKED_BOOT_COMPLETED) {

            // Initialize alarm service
            AlarmMaker(context!!)
        }
    }

}