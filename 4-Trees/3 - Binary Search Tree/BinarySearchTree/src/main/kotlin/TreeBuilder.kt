package org.example

fun buildTree(values: List<Int?>): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null

    val root = TreeNode(values[0]!!)
    val queue: ArrayDeque<TreeNode> = ArrayDeque()
    queue.addLast(root)

    var i = 1
    while (i < values.size && queue.isNotEmpty()) {
        val current = queue.removeFirst()

        // Left child
        if (i < values.size && values[i] != null) {
            val leftNode = TreeNode(values[i]!!)
            current.left = leftNode
            queue.addLast(leftNode)
        }
        i++

        // Right child
        if (i < values.size && values[i] != null) {
            val rightNode = TreeNode(values[i]!!)
            current.right = rightNode
            queue.addLast(rightNode)
        }
        i++
    }

    return root
}