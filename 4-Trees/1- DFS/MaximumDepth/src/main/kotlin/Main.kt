package org.example

fun main() {
    println("Hello DFS playground!")

    // building the tree
    val root = buildTree(listOf(2,null,3,null,4,null,5,null,6))

    // Testing :
    println(minDepth(root))

}