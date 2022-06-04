package com.example.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.notification.service.CHANNEL_DESCRIPTION
import com.example.notification.service.CHANNEL_ID
import com.example.notification.service.CHANNEL_NAME

const val TAG = "MainActivityMain"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize alarm service
//        AlarmMaker(this)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = CHANNEL_NAME
            val descriptionText = CHANNEL_DESCRIPTION
            val importance = NotificationManager.IMPORTANCE_HIGH // pops up the notification
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(NotificationManager::class.java)

            notificationManager.createNotificationChannel(channel)
        }


        // Create an explicit intent for an Activity in your app
        val intentMainActivity = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.getActivity(this, 0, intentMainActivity, PendingIntent.FLAG_IMMUTABLE)
        } else {
            null
        }


        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentTitle("Open the app")
            .setContentText("This action is required after reboot")
            .setDefaults(Notification.DEFAULT_ALL) // this is for sound or vibration or some other fancy thing
            .setPriority(NotificationCompat.PRIORITY_HIGH) // pops up the notification
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()


        with(NotificationManagerCompat.from(this)) {
            notify(-1, notification)
        }


    }
}