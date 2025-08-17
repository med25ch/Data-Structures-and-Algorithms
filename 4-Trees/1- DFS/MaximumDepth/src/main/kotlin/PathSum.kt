package org.example

class PathSum {

    fun hasPathSum(root: Node<Int>?, targetSum: Int): Boolean {
        return dfs(root, 0, targetSum)
    }

    private fun dfs(currentNode: Node<Int>?, current: Int, target: Int): Boolean {
        if (currentNode == null) return false

        if (currentNode.left == null && currentNode.right == null) {
            return (current + currentNode.value) == target
        }

        val newCurrent = current + currentNode.value
        val left = dfs(currentNode.left, newCurrent, target)
        val right = dfs(currentNode.right, newCurrent, target)
        return left || right
    }

}