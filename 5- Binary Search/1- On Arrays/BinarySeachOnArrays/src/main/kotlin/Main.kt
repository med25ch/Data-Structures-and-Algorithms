package org.example

fun main() {

    println("Hello Binary Search for Arrays!")

    val matrix1: Array<IntArray> = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60)
    )

    val matrix2: Array<IntArray> = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60)
    )

    val m2 = arrayOf(
        intArrayOf(5)
    )

    println(searchMatrix(m2, 5))
}