package com.example.notification.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.notification.*
import java.io.Serializable

class LockedBootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        intent?.let {

            // checks for reboot but before the device is unlocked
            if (intent.action == Intent.ACTION_LOCKED_BOOT_COMPLETED) {

                Toast.makeText(context, "ACTION_LOCKED_BOOT_COMPLETED", Toast.LENGTH_LONG)
                    .show()

                val notificationList = intent.getSerializableExtra(NOTIFICATION_LIST) as? NotificationMaker



                if (context != null) {
                    NotificationMaker(context)
                } else {
                    Toast.makeText(context, "Unable to set alarm after reboot", Toast.LENGTH_LONG)
                        .show()
                }
//                    createNotificationChannel(context)
//                    val notification = createNotificationContent(context, "Notification Title")
//                    notify(context, NOTIFICATION_ID, notification)
            }

        }
    }

}