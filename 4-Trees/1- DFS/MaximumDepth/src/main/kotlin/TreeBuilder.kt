package org.example

fun <T> buildTreeFromArray(arr: List<T>): TreeNode<T>? {
    if (arr.isEmpty()) return null

    val root = TreeNode(arr[0])
    val queue: ArrayDeque<TreeNode<T>> = ArrayDeque()
    queue.add(root)

    var i = 1
    while (i < arr.size) {
        val current = queue.removeFirst()

        if (i < arr.size) {
            current.left = TreeNode(arr[i++])
            queue.add(current.left!!)
        }
        if (i < arr.size) {
            current.right = TreeNode(arr[i++])
            queue.add(current.right!!)
        }
    }
    return root
}


fun <T : Any> buildTree(values: List<T?>): TreeNode<T>? {
    if (values.isEmpty() || values[0] == null) return null

    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode<T>>()
    queue.addLast(root)

    var i = 1
    while (i < values.size && queue.isNotEmpty()) {
        val current = queue.removeFirst()

        // left child
        if (i < values.size && values[i] != null) {
            val leftNode = TreeNode(values[i]!!)
            current.left = leftNode
            queue.addLast(leftNode)
        }
        i++

        // right child
        if (i < values.size && values[i] != null) {
            val rightNode = TreeNode(values[i]!!)
            current.right = rightNode
            queue.addLast(rightNode)
        }
        i++
    }
    return root
}