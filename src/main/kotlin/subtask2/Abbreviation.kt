package subtask2


fun main(args: Array<String>){
    //val res = Abbreviation().abbreviationFromA("daBcd", "ABC")
    val res = Abbreviation().abbreviationFromA ("ytrewq", "RY")
    println(res)
}

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val upperString = a.toUpperCase()
        val filteredString =  upperString.filter { b.contains(it) }
        return if (filteredString == b) "YES" else "NO"
    }
}
