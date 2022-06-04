package com.example.notification.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.notification.R


const val CHANNEL_ID = "channel id"
const val CHANNEL_NAME = "Main Channel/Category"
const val CHANNEL_DESCRIPTION = "channel description"

class NotificationMaker(private val context: Context) {

    init {
        createNotificationChannel()
    }

    // this just creates a channel/category of notification
    private fun createNotificationChannel() {
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

    // this builds the actual content to be passed in the notification
    fun notificationBuilder(trashBagColor: String): Notification {
        return NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentTitle("$trashBagColor color garbage bag for tomorrow")
            .setDefaults(Notification.DEFAULT_ALL) // this is for sound or vibration or some other fancy thing
            .setPriority(NotificationCompat.PRIORITY_HIGH) // pops up the notification
            .build()
    }

    // this notifies the user as a popup notification as well sticks to notification drawer
    fun notify(notificationID: Int, notification: Notification) {
        with(NotificationManagerCompat.from(context)) {
            notify(notificationID, notification)
        }
    }

}