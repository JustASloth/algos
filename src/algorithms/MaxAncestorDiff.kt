package algorithms

import kotlin.math.abs
import kotlin.math.max

/**
 * Solution to the "Maximum Difference Between Node and Ancestor" problem on LeetCode.
 *
 * Link to the problem: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class MaxAncestorDiff {
    fun maxAncestorDiff(root: TreeNode3?): Int {
        var ans = 0

        fun dfs(node: TreeNode3?, min: Int, max: Int) {
            if (node != null) {
                val curr = node.`val`
                val thisDiff = max(abs(min - curr), abs(max - curr))
                val newMax = if (curr > max) curr else max
                val newMin = if (curr < min) curr else min
                if (thisDiff > ans) ans = thisDiff
                dfs(node.left, newMin, newMax)
                dfs(node.right, newMin, newMax)
            }
        }

        dfs(root, root!!.`val`, root.`val`)

        return ans
    }
}

class TreeNode3(var `val`: Int) {
    var left: TreeNode3? = null
    var right: TreeNode3? = null
}