package org.example

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 */


fun minDepth(root: TreeNode<Int>?): Int {

    if(root == null) {
        return 0
    }

    // leaf node
    if (root.left == null && root.right == null) return 1

    // if one child is null, take the other
    if (root.left == null) return minDepth(root.right) + 1
    if (root.right == null) return minDepth(root.left) + 1

    val left = minDepth(root.left)
    val right = minDepth(root.right)

    return minOf(left,right) + 1
}
