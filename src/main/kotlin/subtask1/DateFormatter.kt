package subtask1

import java.util.Locale

import java.text.SimpleDateFormat
import java.time.LocalDate

/*
fun main(args: Array<String>){
    val res = DateFormatter().toTextDay("29", "2", "2019")
    println(res)
}
*/

class DateFormatter {
    var locale = Locale("ru")

    fun toTextDay(day: String, month: String, year: String): String {
        var result = ""

        result = if (dateCorrect(day, month, year)) {
            val date = SimpleDateFormat(PATTERN_TO_DATE).parse("$day $month $year")
            val stringDate = SimpleDateFormat(PATTERN_TO_STR, locale).format(date)
            stringDate
        } else {
            DATE_NOT_EXISTS
        }

        return result
    }

    private fun dateCorrect(day: String, month: String, year: String): Boolean {
        try {
            LocalDate.of(year.toInt(), month.toInt(), day.toInt())
        } catch (e: Exception) {
            return false
        }

        return true
    }

    companion object {
        const val PATTERN_TO_STR = "d MMMM, EEEE"
        const val PATTERN_TO_DATE = "dd MM yyyy"
        const val DATE_NOT_EXISTS = "Такого дня не существует"
    }
}

