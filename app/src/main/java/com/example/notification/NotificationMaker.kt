package com.example.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.io.Serializable

class NotificationMaker(context: Context, trashBag: TrashBag): Serializable {


    init {
        createNotificationChannel(context)
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

    private fun createNotificationContent(
        context: Context,
        trashBag: TrashBag
    ): Notification {
        return NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentTitle("${trashBag.bagColor.bagColor} color garbage bag for tomorrow")
//            .setContentText("textContent")
            .setDefaults(Notification.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH) // pops up the notification
            .build()
    }



    private fun notify(context: Context, notificationID: Int, notification: Notification) {
        with(NotificationManagerCompat.from(context)) {
            notify(notificationID, notification)
//            Toast.makeText(context, "notifying", Toast.LENGTH_LONG)
//                .show()
        }
    }

}