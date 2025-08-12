package org.example

import kotlin.math.max

fun main() {
    println("Hello maximumUniqueSubarray!")
    println(maximumUniqueSubarray(intArrayOf(5,2,1,2,5,2,1,2,5)))
}

fun maximumUniqueSubarray(nums: IntArray): Int {

    val hashSet =  hashSetOf<Int>()
    var left = 0
    var curr = 0
    var sum = 0

    for (right in nums.indices) {

        while (hashSet.contains(nums[right]) && left < right) {
            hashSet.remove(nums[left])
            curr -= nums[left]
            left ++
        }

        hashSet.add(nums[right])
        curr += nums[right]

        sum = maxOf(sum , curr)

    }

    return sum
}