package com.example.notification

import android.app.*
import android.app.AlarmManager.RTC_WAKEUP
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import com.example.notification.data.TrashBags
import com.example.notification.receiver.LockedBootReceiver
import java.util.*


const val NOTIFICATION_ID = "notification id"
const val CHANNEL_ID = "channel id"

const val CHANNEL_NAME = "channel name"
const val CHANNEL_DESCRIPTION = "channel description"

const val REQUEST_CODE1 = 1
const val REQUEST_CODE2 = 2


const val TAG = "MainActivityMain"
//const val BAG_COLOR = "BAG_COLOR"
//const val DATA = "DATA"
//const val NOTIFICATION_LIST = "Notification List"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationMaker = NotificationMaker(this)
        Toast.makeText(this, "notification channel created", Toast.LENGTH_LONG).show()

        val months = arrayOf(
            TrashBags.januaryTrashBags(),
            TrashBags.februaryTrashBags(),
            TrashBags.marchTrashBags(),
            TrashBags.aprilTrashBags(),
            TrashBags.mayTrashBags(),
            TrashBags.juneTrashBags(),
            TrashBags.julyTrashBags(),
            TrashBags.augustTrashBags(),
            TrashBags.septemberTrashBags(),
            TrashBags.octoberTrashBags(),
            TrashBags.novemberTrashBags(),
            TrashBags.decemberTrashBags(),
        )


        val alarmManager = getSystemService(ALARM_SERVICE) as? AlarmManager
        val tenMinutesDelay = 1 * 60 * 1000L * 0


        // Looping over all the days in the list
        // A list of trashbags is organized monthwise
        // and each trashbag in a month is organized colorwise
        // and each trashbag in that has DAY_OF_THE_WEEK
        for (i in 0..months.size) {
            val aTrashBagList = months[i]
            for (j in 0..aTrashBagList.size) {
                val aTrashBag = aTrashBagList[j]
                val notification =
                    notificationMaker.createNotificationContent(aTrashBag.bagColor.bagColor)
                for (k in 0..aTrashBag.days.size) {
                    val aDay = aTrashBag.days[k].day
                    val aMonth = aTrashBag.month.month

                    val cal = Calendar.getInstance()
                    cal.set(Calendar.MONTH, aMonth)
                    cal.set(Calendar.DAY_OF_MONTH, aDay)
                    cal.set(Calendar.HOUR, 12)
                    cal.set(Calendar.MINUTE, 0)
                    cal.set(Calendar.SECOND, 0)

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        alarmManager?.setWindow(
                            RTC_WAKEUP, cal.timeInMillis, tenMinutesDelay, "WHAT'S THE PURPOSE OF THIS TAG",
                            {
                                Toast.makeText(baseContext, "Alarm receiver", Toast.LENGTH_LONG)
                                    .show()
                                Log.d(TAG, "Alarm receiver")

                                val notificationManagerCompat =
                                    NotificationManagerCompat.from(baseContext)
                                notificationManagerCompat.notify(
                                    SystemClock.elapsedRealtime().toInt(),
                                    notification
                                )

                            }, null
                        )
                    }

                }
            }
        }
    }


//    private fun createNotificationChannel() {
//        // Create the NotificationChannel, but only on API 26+ because
//        // the NotificationChannel class is new and not in the support library
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val name = CHANNEL_NAME
//            val descriptionText = CHANNEL_DESCRIPTION
//            val importance = NotificationManager.IMPORTANCE_HIGH // pops up the notification
//            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
//                description = descriptionText
//            }
//            // Register the channel with the system
//            val notificationManager: NotificationManager =
//                getSystemService(NotificationManager::class.java)
//
//            notificationManager.createNotificationChannel(channel)
//        }
//    }

}


//        var pendingIntent: PendingIntent? = null
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            pendingIntent =
//                PendingIntent.getBroadcast(
//                    this,
//                    SystemClock.elapsedRealtime().toInt(),
//                    intent,
//                    FLAG_IMMUTABLE
//                )
//        }


//        alarmManager?.setWindow(
//            AlarmManager.RTC_WAKEUP,
//            cal.timeInMillis,
//            tenMinutesDelay,
//            pendingIntent
//        )


//val juneTrashBags = TrashBags.juneTrashBags()
//val juneFirstTrashBag = juneTrashBags[1]
//val month = juneFirstTrashBag.month
//val days = juneFirstTrashBag.days
//val bagColor = juneFirstTrashBag.bagColor