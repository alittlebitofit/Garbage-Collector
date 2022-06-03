package com.example.notification.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.notification.*
import java.io.Serializable

class LockedBootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val contentTitle = intent?.getIntExtra("DATA", 0) ?: 0
        val notificationId = intent?.getIntExtra(NOTIFICATION_ID, 0) ?: 0

        val builder = NotificationCompat.Builder(context!!, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentTitle("$contentTitle")
            .setContentText("Content of notification")
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        val notificationManagerCompat = NotificationManagerCompat.from(context)

        notificationManagerCompat.notify(notificationId, builder.build())

    }

}