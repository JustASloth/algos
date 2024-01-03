package algorithms

fun main() {
    val solution = ClimbingStairs()
    println(solution.climbStairs(1))
}

class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        if (n == 1)
            return 1
        val table = IntArray(n+1)
        table[1] = 1
        table[2] = 2

        for (i in 3 .. n) {
            table[i] = table[i - 1] + table[i - 2]
        }
        return table[n]
    }
}