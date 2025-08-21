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