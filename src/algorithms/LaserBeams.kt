package algorithms

/**
 * Solution to the "Number of Laser Beams in a Bank" problem on LeetCode.
 *
 * Link to the problem: https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
 *
 * My initial intuition was to count the amount of devices in each row and then multiply them.
 * Later I discovered that I can do the multiplication while discovering the devices, thus reducing time complexity.
 */

fun main() {
    val solution = LaserBeams()

    val bank = arrayOf("011001","000000","010100","001000")
    println(solution.numberOfBeamsOptimized(bank))
}

class LaserBeams {
    fun numberOfBeamsOptimized(bank: Array<String>): Int {
        var res = 0
        var prev = 0
        var cur = 0

        bank.forEachIndexed { index, row ->
            row.forEach { device ->
                if (device.digitToInt() == 1) cur++
            }
            res += cur * prev
            if (cur > 0) prev = cur
            cur = 0
        }

        return res
    }

    fun numberOfBeams(bank: Array<String>): Int {
        var resultCount = 0
        val devicePositions = Array<Int>(bank.size) { 0 }

        bank.forEachIndexed { index, row ->
            row.forEach { device ->
                if (device.digitToInt() == 1) devicePositions[index] += 1
            }
        }

        devicePositions.forEachIndexed { rowIndex, devices ->
            val receivers = devicePositions.drop(rowIndex+1).firstOrNull { it > 0 }
            if (receivers != null)
                resultCount += devices * receivers
        }

        return resultCount
    }
}