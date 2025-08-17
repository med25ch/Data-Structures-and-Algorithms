package org.example



/*

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 
 */


fun maxDepth(root: Node<Int>?): Int {

    if(root == null) {
        return 0
    }

    val left = maxDepth(root.left)
    val right = maxDepth(root.right)
    return maxOf(left,right) + 1
}