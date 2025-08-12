package org.example

import java.util.*
import kotlin.math.max

fun main() {
    println("Hello World!")

//    val input = Scanner(System.`in`)
//    val n = input.nextInt()
//    val stockPriceArray = IntArray(n)
//    for (i in 0 until n) {
//        val v = input.nextInt()
//        stockPriceArray[i] = v
//    }

    val test1 = intArrayOf(3,2,4,2,1,5)
    val test2 = intArrayOf(5,3,4,2,3,1)
    val test3 = intArrayOf(1,2,4,4,5)
    println(largestLoss(test1))




}


//Exercise source : https://www.codingame.com/training/medium/stock-exchange-losses


/*
A finance company is carrying out a study on the worst stock investments and would like to acquire a program to do so. The program must be able to analyze a chronological series of stock values in order to show the largest loss that it is possible to make by buying a share at a given time t0 and by selling it at a later date t1. The loss will be expressed as the difference in value between t0 and t1. If there is no loss, the loss will be worth 0.

Input
Line 1: the number n of stock values available.

Line 2: the stock values arranged in order, from the date of their introduction on the stock market v1 until the last known value vn. The values are integers.

Output
The maximal loss p, expressed negatively if there is a loss, otherwise 0.
Constraints
0 < n < 100000
0 < v < 231
 */

fun largestLoss(prices : IntArray) : Int{

    var maxCurrentPrice = 0
    var currLoss = 0
    var largestLoss = 0

    for (i in prices.indices) {

        maxCurrentPrice = maxOf(maxCurrentPrice, prices[i])

        if(prices[i] < maxCurrentPrice) {
            currLoss = prices[i] - maxCurrentPrice
        }

        largestLoss = minOf(largestLoss, currLoss)
    }

    return largestLoss
}