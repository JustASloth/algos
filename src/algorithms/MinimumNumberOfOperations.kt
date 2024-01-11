fun main() {
    val nums = intArrayOf(2,1,2,2,3,3)
    val solution = MinimumNumberOfOperations()

    println(solution.minOperations(nums))
}

class MinimumNumberOfOperations {
    fun minOperations(nums: IntArray): Int {
        val inventory = mutableMapOf<Int, Int>()
        var ans = 0

        nums.forEach { num ->
            if (inventory.contains(num))
                inventory[num] = inventory[num]!! + 1
            else inventory[num] = 1
        }
        inventory.forEach { item ->
            if (item.value == 1) return -1
            ans = if (item.value % 3 != 1) ans + item.value / 3 + (item.value % 3) / 2
            else ans + (item.value - 4) / 3 + ((item.value - 4) % 3) / 2 + 2
        }

        println(inventory)

        return ans
    }
}