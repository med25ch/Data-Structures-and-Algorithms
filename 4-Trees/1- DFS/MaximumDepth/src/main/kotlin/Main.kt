package org.example

fun main() {
    println("Hello DFS playground!")

    // building the tree
    val root = buildTreeFromArray(listOf(1,2,3,4,5,6))

    // Testing :
    println(countNodes(root))

}