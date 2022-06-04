package com.example.notification.service

import android.app.AlarmManager
import android.content.Context
import android.os.Build
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notification.data.TrashBags
import java.util.*

class AlarmMaker(private val context: Context) {

    init {
        createAlarm()
    }

    private fun createAlarm() {

        val notificationMaker = NotificationMaker(context)

        // list of months with all the dates to use
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


        val alarmManager =
            context.getSystemService(AppCompatActivity.ALARM_SERVICE) as? AlarmManager

        // ten minute delay from when the alarm is scheduled to go off
        // to within which time it can go off
        // this is to save battery life, because device goes in doze mode
        val tenMinuteDelay = 10 * (60 * 1000L)


        // Looping over all the days in the list
        //
        // A list of trashbags is organized monthwise
        // and each trashbag in a month is organized colorwise
        // and each trashbag in that has DAY_OF_THE_MONTH
        for (i in 0 until months.size) {
            val aTrashBagList = months[i]

            // this loops over trash bags from inside each month
            for (j in 0 until aTrashBagList.size) {
                val aTrashBag = aTrashBagList[j]
                val notification =
                    notificationMaker.notificationBuilder(aTrashBag.bagColor.bagColor)

                // a trash bag finally categorized by color
                for (k in 0 until aTrashBag.days.size) {
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
                            AlarmManager.RTC_WAKEUP,
                            cal.timeInMillis,
                            tenMinuteDelay,
                            "WHAT'S THE PURPOSE OF THIS TAG?",
                            {
                                notificationMaker.notify(
                                    SystemClock.elapsedRealtime().toInt(),
                                    notification
                                )

                            },
                            null
                        )
                    }

                }
            }
        }
        Toast.makeText(context, "Alarms set successfully!", Toast.LENGTH_LONG).show()
    }

}