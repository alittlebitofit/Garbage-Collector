package com.example.notification.data


data class TrashBag(val month: Month, val days: Array<Day>, val bagColor: BagColor)

data class Month(val month: Int)
data class Day(val day: Int)
data class BagColor(val bagColor: String)

enum class MonthOfYear(private val monthNumber: Int) {
    JANUARY(0),
    FEBRUARY(1),
    MARCH(2),
    APRIL(3),
    MAY(4),
    JUNE(5),
    JULY(6),
    AUGUST(7),
    SEPTEMBER(8),
    OCTOBER(9),
    NOVEMBER(10),
    DECEMBER(11),
}

object TrashBags {
    // january trash bags
    fun januaryTrashBags(): List<TrashBag> {
        val januaryTrashBag = mutableListOf<TrashBag>()
        januaryTrashBag.add(
            TrashBag(
                Month(MonthOfYear.JANUARY.ordinal),
                arrayOf(Day(18)),
                BagColor("Gray")
            )
        )
        januaryTrashBag.add(
            TrashBag(
                Month(MonthOfYear.JANUARY.ordinal),
                arrayOf(Day(12), Day(26)),
                BagColor("Green")
            )
        )
        januaryTrashBag.add(
            TrashBag(
                Month(MonthOfYear.JANUARY.ordinal),
                arrayOf(Day(5), Day(19)),
                BagColor("Purple")
            )
        )
        return januaryTrashBag
    }

    // february trash bags
    fun februaryTrashBags(): List<TrashBag> {
        val februaryTrashBags = mutableListOf<TrashBag>()
        februaryTrashBags.add(
            TrashBag(
                Month(MonthOfYear.FEBRUARY.ordinal),
                arrayOf(Day(15)),
                BagColor("Gray")
            )
        )
        februaryTrashBags.add(
            TrashBag(
                Month(MonthOfYear.FEBRUARY.ordinal),
                arrayOf(Day(9), Day(23)),
                BagColor("Green")
            )
        )
        februaryTrashBags.add(
            TrashBag(
                Month(MonthOfYear.FEBRUARY.ordinal),
                arrayOf(Day(2), Day(16)),
                BagColor("Purple")
            )
        )
        return februaryTrashBags
    }

    // march trash bags
    fun marchTrashBags(): List<TrashBag> {
        val marchTrashBags = mutableListOf<TrashBag>()
        marchTrashBags.add(
            TrashBag(
                Month(MonthOfYear.MARCH.ordinal),
                arrayOf(Day(15)),
                BagColor("Gray")
            )
        )
        marchTrashBags.add(
            TrashBag(
                Month(MonthOfYear.MARCH.ordinal),
                arrayOf(Day(9), Day(23)),
                BagColor("Green")
            )
        )
        marchTrashBags.add(
            TrashBag(
                Month(MonthOfYear.MARCH.ordinal),
                arrayOf(Day(2), Day(16), Day(30)),
                BagColor("Purple")
            )
        )
        return marchTrashBags
    }

    // april trash bags
    fun aprilTrashBags(): List<TrashBag> {
        val aprilTrashBags = mutableListOf<TrashBag>()
        aprilTrashBags.add(
            TrashBag(
                Month(MonthOfYear.APRIL.ordinal),
                arrayOf(Day(12)),
                BagColor("Gray")
            )
        )
        aprilTrashBags.add(
            TrashBag(
                Month(MonthOfYear.APRIL.ordinal),
                arrayOf(Day(6), Day(20)),
                BagColor("Green")
            )
        )
        aprilTrashBags.add(
            TrashBag(
                Month(MonthOfYear.APRIL.ordinal),
                arrayOf(Day(13), Day(27)),
                BagColor("Purple")
            )
        )
        return aprilTrashBags
    }

    // may trash bags
    fun mayTrashBags(): List<TrashBag> {
        val mayTrashBags = mutableListOf<TrashBag>()
        mayTrashBags.add(
            TrashBag(
                Month(MonthOfYear.MAY.ordinal),
                arrayOf(Day(10)),
                BagColor("Gray")
            )
        )
        mayTrashBags.add(
            TrashBag(
                Month(MonthOfYear.MAY.ordinal),
                arrayOf(Day(4), Day(18)),
                BagColor("Green")
            )
        )
        mayTrashBags.add(
            TrashBag(
                Month(MonthOfYear.MAY.ordinal),
                arrayOf(Day(11), Day(27)),
                BagColor("Purple")
            )
        )
        return mayTrashBags
    }

    // june trash bags
    fun juneTrashBags(): List<TrashBag> {
        val juneTrashBags = mutableListOf<TrashBag>()
        juneTrashBags.add(
            TrashBag(
                Month(MonthOfYear.JUNE.ordinal),
                arrayOf(Day(7)),
                BagColor("Gray")
            )
        )
        juneTrashBags.add(
            TrashBag(
                Month(MonthOfYear.JUNE.ordinal),
                arrayOf(Day(1), Day(4), Day(15), Day(29)),
                BagColor("Green")
            )
        )
        juneTrashBags.add(
            TrashBag(
                Month(MonthOfYear.JUNE.ordinal),
                arrayOf(Day(8), Day(22)),
                BagColor("Purple")
            )
        )
        return juneTrashBags
    }

    // july trash bags
    fun julyTrashBags(): List<TrashBag> {
        val julyTrashBags = mutableListOf<TrashBag>()
        julyTrashBags.add(
            TrashBag(
                Month(MonthOfYear.JULY.ordinal),
                arrayOf(Day(5)),
                BagColor("Gray")
            )
        )
        julyTrashBags.add(
            TrashBag(
                Month(MonthOfYear.JULY.ordinal),
                arrayOf(Day(13), Day(27)),
                BagColor("Green")
            )
        )
        julyTrashBags.add(
            TrashBag(
                Month(MonthOfYear.JULY.ordinal),
                arrayOf(Day(6), Day(20)),
                BagColor("Purple")
            )
        )
        return julyTrashBags
    }

    // august trash bags
    fun augustTrashBags(): List<TrashBag> {
        val augustTrashBags = mutableListOf<TrashBag>()
        augustTrashBags.add(
            TrashBag(
                Month(MonthOfYear.AUGUST.ordinal),
                arrayOf(Day(2), Day(30)),
                BagColor("Gray")
            )
        )
        augustTrashBags.add(
            TrashBag(
                Month(MonthOfYear.AUGUST.ordinal),
                arrayOf(Day(10), Day(24)),
                BagColor("Green")
            )
        )
        augustTrashBags.add(
            TrashBag(
                Month(MonthOfYear.AUGUST.ordinal),
                arrayOf(Day(3), Day(17), Day(31)),
                BagColor("Purple")
            )
        )
        return augustTrashBags
    }

    // september trash bags
    fun septemberTrashBags(): List<TrashBag> {
        val septemberTrashBags = mutableListOf<TrashBag>()
        septemberTrashBags.add(
            TrashBag(
                Month(MonthOfYear.SEPTEMBER.ordinal),
                arrayOf(Day(27)),
                BagColor("Gray")
            )
        )
        septemberTrashBags.add(
            TrashBag(
                Month(MonthOfYear.SEPTEMBER.ordinal),
                arrayOf(Day(7), Day(21)),
                BagColor("Green")
            )
        )
        septemberTrashBags.add(
            TrashBag(
                Month(MonthOfYear.SEPTEMBER.ordinal),
                arrayOf(/*Day(1) */Day(14),
                    Day(28)
                ), /////// 1st September should become 31st august Purple
                BagColor("Purple")
            )
        )
        return septemberTrashBags
    }

    // october trash bags
    fun octoberTrashBags(): List<TrashBag> {
        val octoberTrashBags = mutableListOf<TrashBag>()
        octoberTrashBags.add(
            TrashBag(
                Month(MonthOfYear.OCTOBER.ordinal),
                arrayOf(Day(25)),
                BagColor("Gray")
            )
        )
        octoberTrashBags.add(
            TrashBag(
                Month(MonthOfYear.OCTOBER.ordinal),
                arrayOf(Day(5), Day(19)),
                BagColor("Green")
            )
        )
        octoberTrashBags.add(
            TrashBag(
                Month(MonthOfYear.OCTOBER.ordinal),
                arrayOf(Day(12), Day(26)),
                BagColor("Purple")
            )
        )
        return octoberTrashBags
    }

    // november trash bags
    fun novemberTrashBags(): List<TrashBag> {
        val novemberTrashBags = mutableListOf<TrashBag>()
        novemberTrashBags.add(
            TrashBag(
                Month(MonthOfYear.NOVEMBER.ordinal),
                arrayOf(Day(22)),
                BagColor("Gray")
            )
        )
        novemberTrashBags.add(
            TrashBag(
                Month(MonthOfYear.NOVEMBER.ordinal),
                arrayOf(Day(2), Day(16), Day(30)),
                BagColor("Green")
            )
        )
        novemberTrashBags.add(
            TrashBag(
                Month(MonthOfYear.NOVEMBER.ordinal),
                arrayOf(Day(9), Day(23)),
                BagColor("Purple")
            )
        )
        return novemberTrashBags
    }

    // december trash bags
    fun decemberTrashBags(): List<TrashBag> {
        val decemberTrashBags = mutableListOf<TrashBag>()
        decemberTrashBags.add(
            TrashBag(
                Month(MonthOfYear.DECEMBER.ordinal),
                arrayOf(Day(20)),
                BagColor("Gray")
            )
        )
        decemberTrashBags.add(
            TrashBag(
                Month(MonthOfYear.DECEMBER.ordinal),
                arrayOf(/* Day(1),*/ Day(14),
                    Day(28)
                ), ////////////////////// 1st dec should be November 30 green
                BagColor("Green")
            )
        )
        decemberTrashBags.add(
            TrashBag(
                Month(MonthOfYear.DECEMBER.ordinal),
                arrayOf(Day(7), Day(21)),
                BagColor("Purple")
            )
        )
        return decemberTrashBags
    }
}