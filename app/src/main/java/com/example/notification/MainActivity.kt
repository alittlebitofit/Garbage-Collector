package com.example.notification

import android.app.Notification
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat


const val NOTIFICATION_ID = 1
const val CHANNEL_ID = "channel id"

const val CHANNEL_NAME = "channel name"
const val CHANNEL_DESCRIPTION = "channel description"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationReceiver = NotificationReceiver(this)

        notificationReceiver.notify(NOTIFICATION_ID, createNotification("Notification Title here"))

    }



    private fun createNotification(notificationTitle: String): Notification {

        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentTitle(notificationTitle)
            .setContentText("textContent")
            .setDefaults(Notification.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH) // pops up the notification
            .build()
    }

}