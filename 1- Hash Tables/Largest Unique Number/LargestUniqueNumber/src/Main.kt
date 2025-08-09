fun main() {
    println("Hello largestUniqueNumber !")
    println(largestUniqueNumber(intArrayOf(9,9,8,8)))
    println(largestUniqueNumber(intArrayOf(5,7,3,9,4,9,8,3,1)))
}

/*
Given an integer array nums, return the largest integer that only occurs once.

If no integer occurs once, return -1.
 */

fun largestUniqueNumber(nums: IntArray): Int {

    val hashSolution = hashMapOf<Int, Int>()

    for (item in nums) {
        hashSolution[item] = hashSolution.getOrDefault(item, 0) + 1
    }

    return hashSolution
        .filter { it.value == 1 }
        .keys
        .maxOrNull() ?: -1
}