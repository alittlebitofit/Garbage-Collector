package com.example.notification.service

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import com.example.notification.NOTIFICATION_ID
import com.example.notification.NotificationMaker
import com.example.notification.TAG
import com.example.notification.data.TrashBags
import com.example.notification.receiver.LockedBootReceiver
import java.util.*

class AlarmService(private val context: Context) {

    init {
        createAlarm()
    }

    private fun createAlarm() {

        val notificationMaker = NotificationMaker(context)

        val januaryTrashBags = TrashBags.januaryTrashBags()
        val januaryFirstTrashBag = januaryTrashBags[0]
        val month = januaryFirstTrashBag.month
        val days = januaryFirstTrashBag.days
        val bagColor = januaryFirstTrashBag.bagColor

        notificationMaker.createNotificationContent(januaryFirstTrashBag.bagColor.bagColor)

        val notificationTitle = ""

        val intent = Intent(context, LockedBootReceiver::class.java)
        intent.putExtra("DATA", SystemClock.elapsedRealtime().toInt())
        intent.putExtra(NOTIFICATION_ID, SystemClock.elapsedRealtime().toInt())

        var pendingIntent: PendingIntent? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            pendingIntent =
                PendingIntent.getBroadcast(
                    context,
                    SystemClock.elapsedRealtime().toInt(),
                    intent,
                    PendingIntent.FLAG_IMMUTABLE
                )
        }

        val alarmManager =
            context.getSystemService(AppCompatActivity.ALARM_SERVICE) as? AlarmManager

        val cal = Calendar.getInstance()
        cal.set(Calendar.MONTH, 5)
        cal.set(Calendar.DAY_OF_MONTH, 4)
        cal.set(Calendar.HOUR, 2)
        cal.set(Calendar.MINUTE, 38)

        Log.d(TAG, cal.time.toString())
        Log.d(TAG, cal.timeInMillis.toString())

        val currentTime = System.currentTimeMillis()
        val tenMinutesDelay = 10 * 60 * 1000L

        alarmManager?.setWindow(
            AlarmManager.RTC_WAKEUP,
            cal.timeInMillis,
            tenMinutesDelay,
            pendingIntent
        )


    }

}