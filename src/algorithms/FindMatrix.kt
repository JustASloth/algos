package algorithms

fun main() {
    val solution = FindMatrix()
    println(solution.findMatrix2(intArrayOf(1,3,4,1,2,3,1)))

}

class FindMatrix {
    fun findMatrix(nums: IntArray): List<List<Int>> {
        val occurrence = mutableMapOf<Int, Int>()

        nums.forEach { num ->
            if (occurrence.contains(num))
                occurrence[num] = occurrence[num]!! + 1
            else
                occurrence[num] = 1
        }

        val result = MutableList(occurrence.values.max()) { mutableListOf<Int>() }

        occurrence.forEach { num ->
            for (i in 1 .. num.value) {
                result[i-1].add(num.key)
            }
        }

        println(occurrence)

        return result
    }

    fun findMatrix2(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        val occurrence = IntArray(nums.size+1)

        nums.forEach { num ->
            if (result.size <= occurrence[num])
                result.add(mutableListOf())

            result[occurrence[num]].add(num)
            occurrence[num] += 1

        }

        return result
    }
}