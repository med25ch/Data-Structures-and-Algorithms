package org.example

/*
1305. All Elements in Two Binary Search Trees

Given two binary search trees root1 and root2,

return a list containing all the integers from both trees sorted in ascending order.

 */

fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {

    if (root1 == null && root2 == null) return emptyList()

    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()

    inorder(root1,list1)
    inorder(root2,list2)

    if (list1.isEmpty()) return list2
    if (list2.isEmpty()) return list1

    return mergeSorted(list1, list2)
}


private fun inorder(node: TreeNode?, out: MutableList<Int>) {
    var curr = node
    val stack = ArrayDeque<TreeNode>()
    while (curr != null || stack.isNotEmpty()) {
        while (curr != null) {
            stack.addLast(curr)
            curr = curr.left
        }
        val n = stack.removeLast()
        out.add(n.`val`)
        curr = n.right
    }
}

private fun mergeSorted(a: List<Int>, b: List<Int>): List<Int> {
    val res = ArrayList<Int>(a.size + b.size)
    var i = 0; var j = 0
    while (i < a.size && j < b.size) {
        if (a[i] <= b[j]) res.add(a[i++]) else res.add(b[j++])
    }
    while (i < a.size) res.add(a[i++])
    while (j < b.size) res.add(b[j++])
    return res
}
