package com.example.notification.receiver

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.notification.MainActivity
import com.example.notification.R
import com.example.notification.service.CHANNEL_DESCRIPTION
import com.example.notification.service.CHANNEL_ID
import com.example.notification.service.CHANNEL_NAME

//import android.app.Notification
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.app.PendingIntent
//import android.content.BroadcastReceiver
//import android.content.Context
//import android.content.Intent
//import android.os.Build
//import androidx.core.app.NotificationCompat
//import androidx.core.app.NotificationManagerCompat
//import com.example.notification.MainActivity
//import com.example.notification.R
//import com.example.notification.service.CHANNEL_DESCRIPTION
//import com.example.notification.service.CHANNEL_ID
//import com.example.notification.service.CHANNEL_NAME
//
class LockedBootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_LOCKED_BOOT_COMPLETED) {

            // Initialize alarm service
//            AlarmMaker(context!!)


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val name = CHANNEL_NAME
                val descriptionText = CHANNEL_DESCRIPTION
                val importance = NotificationManager.IMPORTANCE_HIGH // pops up the notification
                val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                    description = descriptionText
                }
                // Register the channel with the system
                val notificationManager: NotificationManager =
                    context!!.getSystemService(NotificationManager::class.java)

                notificationManager.createNotificationChannel(channel)
            }


            // Create an explicit intent for an Activity in your app
            val intentMainActivity = Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent: PendingIntent? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                PendingIntent.getActivity(context, 0, intentMainActivity, PendingIntent.FLAG_IMMUTABLE)
            } else {
                null
            }


            val notification = NotificationCompat.Builder(context!!, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle("Open the app")
                .setContentText("This action is required after reboot")
                .setDefaults(Notification.DEFAULT_ALL) // this is for sound or vibration or some other fancy thing
                .setPriority(NotificationCompat.PRIORITY_HIGH) // pops up the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()


            with(NotificationManagerCompat.from(context)) {
                notify(-1, notification)
            }

        }
    }

}