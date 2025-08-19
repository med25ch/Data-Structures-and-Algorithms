package org.example

/*
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.
 */

fun goodNodes(root: TreeNode<Int>?): Int {
    return dfs(root, Int.MIN_VALUE)
}

fun dfs(root: TreeNode<Int>?, maxSoFar : Int) : Int{

    if(root == null) {
        return 0
    }

    val left =  dfs(root.left, maxOf(maxSoFar, root.value))
    val right =  dfs(root.right, maxOf(maxSoFar, root.value))

    var ans = left + right

    if(root.value >= maxSoFar) {
        ans += 1
    }

    return ans
}