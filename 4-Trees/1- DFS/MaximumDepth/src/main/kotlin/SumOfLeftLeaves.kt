package org.example

/*
Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 */



fun sumOfLeftLeaves(root: TreeNode<Int>?): Int {
    return dsfSumOfLeftLeaves(root,false)
}

fun dsfSumOfLeftLeaves(root: TreeNode<Int>?, isLeft : Boolean) : Int{

    if (root == null) {
        return 0
    }

    if (root.left == null && root.right == null) {
        return if (isLeft) {
            root.value
        }else {
            0
        }
    }

    val left = dsfSumOfLeftLeaves(root.left,true)
    val right = dsfSumOfLeftLeaves(root.right,false)

    return left + right
}