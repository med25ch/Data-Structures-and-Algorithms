package org.example


/*
Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 */


fun largestValues(root: TreeNode?): List<Int> {

    if(root == null) {
        return listOf()
    }

    val queue : ArrayDeque<TreeNode> = ArrayDeque()
    val largestValueList = mutableListOf<Int>()

    queue.addLast(root)

    while (queue.isNotEmpty()) {

        val nodesInCurrentLevel = queue.size
        var tempMaxValue = Int.MIN_VALUE

        repeat(nodesInCurrentLevel) {
            val node = queue.removeFirst()

            // current node
            tempMaxValue = maxOf(tempMaxValue, node.`val`)

            // next level onto the queue
            node.left?.let {queue.addLast(it)}
            node.right?.let {queue.addLast(it)}
        }

        largestValueList.add(tempMaxValue)

    }

    return largestValueList
}