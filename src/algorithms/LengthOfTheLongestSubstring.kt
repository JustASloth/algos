package algorithms

import kotlin.math.max

/**
 * Solution to the "Longest Substring Without Repeating Characters" problem on LeetCode.
 *
 * Link to the problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * This solution implements the "Sliding Window" approach, as it was the most intuitive approach to me.
 * The solution contains 2 methods:
 * - lengthOfLongestSubstring - the most optimal approach, that utilizes the hash map functionality;
 * - lengthOfLongestSubstringUsingString - my initial solution that relies on simply capturing the longest substring.
 */

fun main() {
    val solution = LengthOfTheLongestSubstring()
    println(solution.lengthOfLongestSubstring("ohvhjdml"))
}

class LengthOfTheLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        val chars = mutableMapOf<Char, Int>()
        var max = 0

        var left = 0

        s.forEachIndexed { right, c ->
            if (chars[c] == null)
                chars[c] = 1
            else
                chars[c] = chars[c]!! + 1

            while (chars[c]!! > 1) {
                chars[s[left]] = (chars[s[left]] ?: 0) - 1
                left++
            }

            max = max(max, right - left + 1)
        }

        return max
    }

    fun lengthOfLongestSubstringUsingString(s: String): Int {
        var current = ""
        var max = 0
        s.forEach { c ->
            if (!current.contains(c)) {
                current += c
                if (current.length > max) max = current.length
            } else {
                current = current.drop(current.indexOf(c) + 1)
                current += c
            }

            max = max(max, current.length)
        }
        return max
    }
}