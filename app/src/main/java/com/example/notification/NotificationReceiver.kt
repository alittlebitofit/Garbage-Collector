package com.example.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
//        Toast.makeText(context, "Notification Receiver: onReceive()", Toast.LENGTH_LONG).show()
        intent?.let {

            if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
                Toast.makeText(context, "Intent.ACTION_BOOT_COMPLETED", Toast.LENGTH_LONG).show()
            }

            if (intent.action == Intent.ACTION_LOCKED_BOOT_COMPLETED) {
                Toast.makeText(context, "Intent.ACTION_LOCKED_BOOT_COMPLETED", Toast.LENGTH_LONG)
                    .show()
            }

        }

    }
}