package subtask3

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

fun main(args: Array<String>){
    val res = Blocks().getData(arrayOf(1, "4", 2, "3"), String::class)
    println(res)
}

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        when (blockB) {
            Int::class -> {
                return blockA.filterIsInstance<Int>().sum()
            }
            String::class -> {
                return blockA.filterIsInstance<String>().joinToString("")
            }
            LocalDate::class -> {
                return blockA.filterIsInstance<LocalDate>().maxBy { it }
                    ?.format(DateTimeFormatter.ofPattern(PATTERN_TO_STR)) ?: ""
            }
        }
        return ""
    }


    companion object {
        const val PATTERN_TO_STR = "dd.MM.yyyy"
    }
}
