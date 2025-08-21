package org.example

fun main() {
    println("Hello World!")

    val root = buildTree(listOf(10,5,15,3,7,null,18))

    println(rangeSumBST(root,7, 15))
}