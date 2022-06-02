package com.example.notification

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notification.data.*
import com.example.notification.receiver.LockedBootReceiver
import com.example.notification.service.AlarmService


const val NOTIFICATION_ID = 1
const val CHANNEL_ID = "channel id"

const val CHANNEL_NAME = "channel name"
const val CHANNEL_DESCRIPTION = "channel description"


const val TAG = "MainTAG"
const val NOTIFICATION_LIST = "Notification List"

class MainActivity : AppCompatActivity() {
    private val sharedPrefFile = "kotlinsharedpreference"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val intent = Intent(this, LockedBootReceiver::class.java).apply {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                action = Intent.ACTION_LOCKED_BOOT_COMPLETED
//                putExtra(NOTIFICATION_LIST, createNotificationIntents())
//            }
//
////            intent.putParcelableArrayListExtra()
//
//            val bundle = intent.extras
////            bundle?.putString(NOTIFICATION_LIST, createNotificationIntents())
//
//
//        }

        val sharedPreferences = this.getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val isFirstRun = sharedPreferences.getBoolean("FIRSTRUN", true)
        editor.putBoolean("FIRSTRUN", false)
        editor.apply()

//        if (isFirstRun) {
//            // Code to run once
//            Toast.makeText(this, "LockedBootReceiver Alarm set successfully", Toast.LENGTH_LONG)
//                .show()
//            AlarmService(this)
//        } else {
//
//            Toast.makeText(this, "LockedBootReceiver Alarm already set", Toast.LENGTH_LONG)
//                .show()
//        }
        AlarmService(this)

    }

    private fun createNotificationIntents(): NotificationMaker {
        val notificationList: MutableList<NotificationMaker> = mutableListOf()

        return NotificationMaker(
            this,
            TrashBag(
                Month(6),
                listOf(Day(7)),
                BagColor("Gray")
            )
        )

    }


}