package org.example

/*

Given the root node of a binary search tree and two integers low and high,

return the sum of values of all nodes with a value in the inclusive range [low, high].
 */


fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {

    if(root == null) {
        return 0
    }

    var answer = 0

    val stack : ArrayDeque<TreeNode> = ArrayDeque()
    stack.addLast(root)

    while(stack.isNotEmpty()) {
        val node = stack.removeLast() ?: continue
        val v = node.`val`

        if (v in low..high) answer += v
        if (v > low) node.left?.let { stack.addLast(it) }   // left could contain >= low
        if (v < high) node.right?.let { stack.addLast(it) } // right could contain <= high
    }

    return answer
}