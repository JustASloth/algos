package algorithms

// Unfinished

fun main() {
    val solution = StrWithout3a3b()
    val string = solution.strWithout3a3b(21, 30)
    println(string)
    println("a: " + string.count { it == 'a' })
    println("b: " + string.count { it == 'b' })
}

class StrWithout3a3b {
    fun strWithout3a3b(a: Int, b: Int): String {
        val total = a + b
        var aa = a
        var bb = b

        var str = ""

//        while (str.length < total) {
//            if (aa > bb)
//        }
        return "a"
    }
//    fun strWithout3a3b(a: Int, b: Int): String {
//        val frequentChar = if (a > b) "a" else "b"
//        val seldomChar = if (a <= b) "a" else "b"
//
//        val total = a.toDouble() + b.toDouble()
//
//        val ratio = if (a <= b) total / a else total / b
//
//        val aRatio = a.toDouble() / total.toDouble()
//        println(aRatio)
//        val bRatio = b.toDouble() / total.toDouble()
//        println(bRatio)
//
//
//
//        println(ratio)
//        var current = 1.0
//        var str: String = ""
//
//        while (str.length < total) {
//            if (current % ratio != 0.0)
//                str += frequentChar
//            else
//                str += seldomChar
//            current++
//        }
//
//        return str
//    }
}