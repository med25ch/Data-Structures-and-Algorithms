package org.example

fun main() {
    println("Hello World!")

    val root1 = buildTree(listOf(null))
    val root2 = buildTree(listOf(5,1,7,0,2))

    println(getAllElements(root1, root2))
}