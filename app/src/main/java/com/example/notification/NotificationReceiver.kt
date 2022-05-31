package com.example.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat

class NotificationReceiver(context: Context) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
//        Toast.makeText(context, "Notification Receiver: onReceive()", Toast.LENGTH_LONG).show()
        intent?.let {

//            if (intent.action == Intent.ACTION_LOCKED_BOOT_COMPLETED || intent.action == Intent.ACTION_BOOT_COMPLETED) {
//                Toast.makeText(context, "BOOT_COMPLETED", Toast.LENGTH_LONG)
//                    .show()
//
//                context?.let {
//                    createNotificationChannel(context)
//                }
//
//            }


            if (intent.action == Intent.ACTION_LOCKED_BOOT_COMPLETED) {
                Toast.makeText(context, "ACTION_LOCKED_BOOT_COMPLETED", Toast.LENGTH_LONG)
                    .show()

                    createNotificationChannel(localContext)

            }

            if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
                Toast.makeText(context, "ACTION_BOOT_COMPLETED", Toast.LENGTH_LONG)
                    .show()

                    createNotificationChannel(localContext)

            }


        }

    }

    private val localContext: Context

    init {
        this.localContext = context
        createNotificationChannel(localContext)
    }

    fun notify(notificationID: Int, notification: Notification) {
        with(NotificationManagerCompat.from(localContext)) {
            notify(notificationID, notification)
            Toast.makeText(localContext, "notif popping", Toast.LENGTH_LONG)
                .show()
        }
    }


    private fun createNotificationChannel(context: Context) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = CHANNEL_NAME
            val descriptionText = CHANNEL_DESCRIPTION
            val importance = NotificationManager.IMPORTANCE_HIGH // pops up the notification
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                context.getSystemService(NotificationManager::class.java)

            notificationManager.createNotificationChannel(channel)
        }
    }

}