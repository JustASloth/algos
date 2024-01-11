package algorithms

import java.util.*
import kotlin.math.max


fun main() {
    val solution = JobScheduling()
    println(solution.jobScheduling(intArrayOf(1,2,3,4,6), intArrayOf(3,5,10,6,9), intArrayOf(20,20,100,70,60)))
}

class JobScheduling {
    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val profitPerHour = IntArray(startTime.size + 1)

        val jobs = Array(startTime.size) { intArrayOf() }
        for (i in startTime.indices)
            jobs[i] = intArrayOf(startTime[i], endTime[i], profit[i])

        jobs.sortBy { it[1] }

        jobs.forEachIndexed { index, job ->
            val previousJobIndex = search(jobs, job[0], index)
            val jobProfit = job[2] + profitPerHour[previousJobIndex]
            profitPerHour[index + 1] = max(profitPerHour[index], jobProfit)
        }
        return profitPerHour.last()
    }

    private fun search(jobs: Array<IntArray>, x: Int, n: Int): Int {
        var left = 0
        var right = n
        while (left < right) {
            val mid = (left + right) shr 1
            if (jobs[mid][1] > x) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    fun jobSchedulingSlow(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val profitPerHour = IntArray(endTime.max() + 1) { 0 }

        for (hour in profitPerHour.indices.drop(1)) {
            val jobsEndThisHour = endTime.indices.filter { index -> endTime[index] == hour }
            val profitThisHour = jobsEndThisHour.maxOfOrNull { jobIndex ->
                profitPerHour[startTime[jobIndex]] + profit[jobIndex]
            } ?: 0
            profitPerHour[hour] = max(profitThisHour, profitPerHour[hour-1])
            println("$hour: ${profitPerHour[hour]}")
        }

        return profitPerHour.max()
    }
}

// Count for each hour
// Compare with previous