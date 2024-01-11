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

class LeafSimilar {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        return dfs(root1).filterNotNull() == dfs(root2).filterNotNull()
    }

    private fun dfs(root: TreeNode?): List<Int?> {
        if (root == null) return listOf(null)
        return if (root.left == null && root.right == null) listOf(root.`val`)
        else dfs(root.left) + dfs(root.right)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}