package algorithms

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
class RangeSumBST {
    fun rangeSumBST(root: TreeNode2?, low: Int, high: Int): Int {
        val nodes = mutableListOf(root)
        var ans = 0

        while (nodes.isNotEmpty()) {
            val node = nodes.first()
            if (node != null) {
                if (node.`val` in low..high)
                    ans += node.`val`

                if (node.`val` > low)
                    nodes.add(node.left)
                if (node.`val` < high)
                    nodes.add(node.right)
            }
            nodes.removeFirst()
        }

        return ans
    }
}

class TreeNode2(var `val`: Int) {
    var left: TreeNode2? = null
    var right: TreeNode2? = null
}