package com.example.notification

import android.app.Notification
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.notification.receiver.LockedBootReceiver


const val NOTIFICATION_ID = 1
const val CHANNEL_ID = "channel id"

const val CHANNEL_NAME = "channel name"
const val CHANNEL_DESCRIPTION = "channel description"


const val TAG = "MainTAG"
const val NOTIFICATION_LIST = "Notification List"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, LockedBootReceiver::class.java).apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                action = Intent.ACTION_LOCKED_BOOT_COMPLETED
                putExtra(NOTIFICATION_LIST, createNotificationIntents())
            }

//            intent.putParcelableArrayListExtra()

            val bundle = intent.extras
//            bundle?.putString(NOTIFICATION_LIST, createNotificationIntents())

        }

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

object TrashBags {

    // january trash bags
    private fun januaryTrashBags(): List<TrashBag> {
        val januaryTrashBag = mutableListOf<TrashBag>()
        januaryTrashBag.add(
            TrashBag(
                Month(1),
                listOf(Day(18)),
                BagColor("Gray")
            )
        )
        januaryTrashBag.add(
            TrashBag(
                Month(1),
                listOf(Day(12), Day(26)),
                BagColor("Green")
            )
        )
        januaryTrashBag.add(
            TrashBag(
                Month(1),
                listOf(Day(5), Day(19)),
                BagColor("Purple")
            )
        )
        return januaryTrashBag
    }

    // february trash bags
    private fun februaryTrashBags(): List<TrashBag> {
        val februaryTrashBags = mutableListOf<TrashBag>()
        februaryTrashBags.add(
            TrashBag(
                Month(3),
                listOf(Day(15)),
                BagColor("Gray")
            )
        )
        februaryTrashBags.add(
            TrashBag(
                Month(3),
                listOf(Day(9), Day(23)),
                BagColor("Green")
            )
        )
        februaryTrashBags.add(
            TrashBag(
                Month(3),
                listOf(Day(2), Day(16)),
                BagColor("Purple")
            )
        )
        return februaryTrashBags
    }

    // march trash bags
    private fun marchTrashBags(): List<TrashBag> {
        val marchTrashBags = mutableListOf<TrashBag>()
        marchTrashBags.add(
            TrashBag(
                Month(3),
                listOf(Day(15)),
                BagColor("Gray")
            )
        )
        marchTrashBags.add(
            TrashBag(
                Month(3),
                listOf(Day(9), Day(23)),
                BagColor("Green")
            )
        )
        marchTrashBags.add(
            TrashBag(
                Month(3),
                listOf(Day(2), Day(16), Day(30)),
                BagColor("Purple")
            )
        )
        return marchTrashBags
    }

    // april trash bags
    private fun aprilTrashBags(): List<TrashBag> {
        val aprilTrashBags = mutableListOf<TrashBag>()
        aprilTrashBags.add(
            TrashBag(
                Month(4),
                listOf(Day(12)),
                BagColor("Gray")
            )
        )
        aprilTrashBags.add(
            TrashBag(
                Month(4),
                listOf(Day(6), Day(20)),
                BagColor("Green")
            )
        )
        aprilTrashBags.add(
            TrashBag(
                Month(4),
                listOf(Day(13), Day(27)),
                BagColor("Purple")
            )
        )
        return aprilTrashBags
    }

    // may trash bags
    private fun mayTrashBags(): List<TrashBag> {
        val mayTrashBags = mutableListOf<TrashBag>()
        mayTrashBags.add(
            TrashBag(
                Month(5),
                listOf(Day(10)),
                BagColor("Gray")
            )
        )
        mayTrashBags.add(
            TrashBag(
                Month(5),
                listOf(Day(4), Day(18)),
                BagColor("Green")
            )
        )
        mayTrashBags.add(
            TrashBag(
                Month(5),
                listOf(Day(11), Day(27)),
                BagColor("Purple")
            )
        )
        return mayTrashBags
    }

    // june trash bags
    private fun juneTrashBags(): List<TrashBag> {
        val juneTrashBags = mutableListOf<TrashBag>()
        juneTrashBags.add(
            TrashBag(
                Month(6),
                listOf(Day(7)),
                BagColor("Gray")
            )
        )
        juneTrashBags.add(
            TrashBag(
                Month(6),
                listOf(Day(1), Day(15), Day(29)),
                BagColor("Green")
            )
        )
        juneTrashBags.add(
            TrashBag(
                Month(6),
                listOf(Day(8), Day(22)),
                BagColor("Purple")
            )
        )
        return juneTrashBags
    }

    // july trash bags
    private fun julyTrashBags(): List<TrashBag> {
        val julyTrashBags = mutableListOf<TrashBag>()
        julyTrashBags.add(
            TrashBag(
                Month(7),
                listOf(Day(5)),
                BagColor("Gray")
            )
        )
        julyTrashBags.add(
            TrashBag(
                Month(7),
                listOf(Day(13), Day(27)),
                BagColor("Green")
            )
        )
        julyTrashBags.add(
            TrashBag(
                Month(7),
                listOf(Day(6), Day(20)),
                BagColor("Purple")
            )
        )
        return julyTrashBags
    }

    // august trash bags
    private fun augustTrashBags(): List<TrashBag> {
        val augustTrashBags = mutableListOf<TrashBag>()
        augustTrashBags.add(
            TrashBag(
                Month(8),
                listOf(Day(2), Day(30)),
                BagColor("Gray")
            )
        )
        augustTrashBags.add(
            TrashBag(
                Month(8),
                listOf(Day(10), Day(24)),
                BagColor("Green")
            )
        )
        augustTrashBags.add(
            TrashBag(
                Month(8),
                listOf(Day(3), Day(17), Day(31)),
                BagColor("Purple")
            )
        )
        return augustTrashBags
    }

    // september trash bags
    private fun septemberTrashBags(): List<TrashBag> {
        val septemberTrashBags = mutableListOf<TrashBag>()
        septemberTrashBags.add(
            TrashBag(
                Month(9),
                listOf(Day(27)),
                BagColor("Gray")
            )
        )
        septemberTrashBags.add(
            TrashBag(
                Month(9),
                listOf(Day(7), Day(21)),
                BagColor("Green")
            )
        )
        septemberTrashBags.add(
            TrashBag(
                Month(9),
                listOf(/*Day(1) */Day(14),
                    Day(28)
                ), /////// 1st September should become 31st august Purple
                BagColor("Purple")
            )
        )
        return septemberTrashBags
    }

    // october trash bags
    private fun octoberTrashBags(): List<TrashBag> {
        val octoberTrashBags = mutableListOf<TrashBag>()
        octoberTrashBags.add(
            TrashBag(
                Month(10),
                listOf(Day(25)),
                BagColor("Gray")
            )
        )
        octoberTrashBags.add(
            TrashBag(
                Month(10),
                listOf(Day(5), Day(19)),
                BagColor("Green")
            )
        )
        octoberTrashBags.add(
            TrashBag(
                Month(10),
                listOf(Day(12), Day(26)),
                BagColor("Purple")
            )
        )
        return octoberTrashBags
    }

    // november trash bags
    private fun novemberTrashBags(): List<TrashBag> {
        val novemberTrashBags = mutableListOf<TrashBag>()
        novemberTrashBags.add(
            TrashBag(
                Month(11),
                listOf(Day(22)),
                BagColor("Gray")
            )
        )
        novemberTrashBags.add(
            TrashBag(
                Month(11),
                listOf(Day(2), Day(16), Day(30)),
                BagColor("Green")
            )
        )
        novemberTrashBags.add(
            TrashBag(
                Month(11),
                listOf(Day(9), Day(23)),
                BagColor("Purple")
            )
        )
        return novemberTrashBags
    }

    // december trash bags
    private fun decemberTrashBags(): List<TrashBag> {
        val decemberTrashBags = mutableListOf<TrashBag>()
        decemberTrashBags.add(
            TrashBag(
                Month(12),
                listOf(Day(20)),
                BagColor("Gray")
            )
        )
        decemberTrashBags.add(
            TrashBag(
                Month(12),
                listOf(/* Day(1),*/ Day(14),
                    Day(28)
                ), ////////////////////// 1st dec should be November 30 green
                BagColor("Green")
            )
        )
        decemberTrashBags.add(
            TrashBag(
                Month(12),
                listOf(Day(7), Day(21)),
                BagColor("Purple")
            )
        )
        return decemberTrashBags
    }
}


data class TrashBag(val month: Month, val days: List<Day>, val bagColor: BagColor)

data class Month(val month: Int)
data class Day(val day: Int)
data class BagColor(val bagColor: String)