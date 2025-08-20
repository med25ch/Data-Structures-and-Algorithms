package org.example

fun main() {
    println("Hello BFS PLAYGROUND!")

    val root = buildTree(listOf(1,2,3,null,5,null,4))
    println(rightSideView(root))

}