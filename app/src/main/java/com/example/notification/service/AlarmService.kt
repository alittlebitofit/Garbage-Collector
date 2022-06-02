package com.example.notification.service

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import java.util.*

class AlarmService(context: Context) {

    init {
        createAlarm(context)
    }

    private fun createAlarm(context: Context) {
        val alarmManager =
            context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager

        val calendar = Calendar.getInstance()
        calendar.set(Calendar.MONTH, 6)
        calendar.set(Calendar.DATE, 3)
        calendar.set(Calendar.HOUR, 3)
        calendar.set(Calendar.MINUTE, 27)

        val timeDelayInMinutes = 10 * 60 * 1000L // 10 minutes


//        Toast.makeText(context, "LockedBootReceiver 1 AlarmManager.OnAlarmListener", Toast.LENGTH_LONG)
//            .show()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            if (alarmManager == null) {
                Toast.makeText(
                    context,
                    "LockedBootReceiver alarmManager == null",
                    Toast.LENGTH_LONG
                )
                    .show()

                Log.d("LockedBootReceiver", "LockedBootReceiver alarmManager == null")
            } else {

                Toast.makeText(
                    context,
                    "LockedBootReceiver alarmManager != null",
                    Toast.LENGTH_LONG
                )
                    .show()

                Log.d("LockedBootReceiver", "LockedBootReceiver alarmManager != null")
                Log.d("LockedBootReceiver", "LockedBootReceiver ${calendar.get(Calendar.MONTH)}")
                Log.d("LockedBootReceiver", "LockedBootReceiver ${calendar.get(Calendar.DATE)}")
                Log.d("LockedBootReceiver", "LockedBootReceiver ${calendar.get(Calendar.HOUR)}")
                Log.d("LockedBootReceiver", "LockedBootReceiver ${calendar.get(Calendar.MINUTE)}")
            }

            alarmManager?.setAlarmClock(
                AlarmManager.AlarmClockInfo(
                    System.currentTimeMillis(),
//                AlarmManager.RTC_WAKEUP,
//                calendar.timeInMillis,
                    PendingIntent()
                )
//                "What Tag?",
//                {
//                    Toast.makeText(context, "LockedBootReceiver Exact alarm set", Toast.LENGTH_LONG)
//                        .show()
//
//                    Log.d("LockedBootReceiver", "LockedBootReceiver Exact alarm set")
//
//                },
//                null
            )


//            alarmManager?.setWindow(
//                AlarmManager.RTC_WAKEUP,
//                calendar.timeInMillis,
//                timeDelayInMinutes,
//                "What Tag?",
//                {
//                    Toast.makeText(context, "LockedBootReceiver AlarmManager.OnAlarmListener", Toast.LENGTH_LONG)
//                        .show()
//
//                    Log.d("LockedBootReceiver", "AlarmManager.OnAlarmListener")
//
//                },
//                null
//            )
        }

//        val pendingIntent =
//            PendingIntent.getService(
//                context, requestId, intent,
//                PendingIntent.FLAG_NO_CREATE
//            )

    }

}