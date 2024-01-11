package algorithms

fun main() {
    val solution = LengthOfLIS()

//    val nums = intArrayOf(0,1,0,3,2,3)
    val nums = intArrayOf(10,9,2,5,3,7,101,18)
    println(solution.lengthOfLIS(nums))
}

class LengthOfLIS {
    fun lengthOfLIS(nums: IntArray): Int {
        val lis = IntArray(nums.size) { 1 }
        var max = 0

        for (i in lis.indices) {
            val subproblems = lis.dropLast(lis.size - i - 1).filterIndexed { index, el -> nums[index] < nums[i] }
            println(lis.dropLast(lis.size - i - 1).filterIndexed { index, el -> nums[index] < nums[i] })
            if (subproblems.isNotEmpty()) lis[i] = subproblems.max() + 1
            else lis[i] = 1

            if (lis[i] > max) max = lis[i]
        }

        return max
    }
}

// LIS n = 1 + maxLIS|k| | k < n, A(k) <  A(n]}