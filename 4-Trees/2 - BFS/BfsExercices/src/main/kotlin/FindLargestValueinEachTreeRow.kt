package org.example

/*
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 */

fun rightSideView(root: TreeNode?): List<Int> {

    if(root == null) {
        return listOf()
    }

    val queue : ArrayDeque<TreeNode> = ArrayDeque()
    val whatISee : MutableList<Int> = mutableListOf()

    queue.addLast(root)

    while(queue.isNotEmpty()) {

        val nodesInCurrentLevel = queue.size
        var prev = 0
        
        repeat(nodesInCurrentLevel) {

            val node = queue.removeFirst()
            prev = node.`val`

            node.left?.let { queue.addLast(it) }
            node.right?.let { queue.addLast(it) }
        }

        whatISee.add(prev)
    }

    return whatISee.toList()
}